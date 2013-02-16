(ns webroti.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.json :as json]
            [webroti.db :as db]))

;; Let's use an in-memory database and a sequence id generator for now.
(def meetings (db/create-in-memory-database))
(def id-gen (db/create-sequence-generator))

(defn- read-body [body]
  (with-open [rdr (clojure.java.io/reader body)]
    (slurp rdr)))

(defn- read-body-as-double [body]
  (let [s (read-body body)]
    (when-not (empty? s)
      (try
        (Double/parseDouble s)
        (catch Exception e nil)))))

(defn- handle-new-meeting []
  (let [id (db/new-meeting meetings id-gen)]
    {:status 201
     :headers {"Location" (str "/meeting/" id)}}))

(defn- handle-get-meeting [id]
  (let [data (db/get-meeting meetings id)]
    (if (nil? data) {:status 204} {:body data})))

(defn- handle-update-meeting [id req]
  (let [vote (read-body-as-double (:body req))]
    (if (nil? vote)
      {:status 400}
      (let [result (db/update-meeting meetings id vote)]
        (if (false? result)
          {:status 412}
          {:status 200})))))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/meeting/:id" [id] (handle-get-meeting id))
  (POST "/meeting" [] (handle-new-meeting))
  (POST "/meeting/:id" [id :as req] (handle-update-meeting id req))
  (route/not-found "Not Found"))

(def app
  (->
   (handler/api app-routes)
   (json/wrap-json-response)))
