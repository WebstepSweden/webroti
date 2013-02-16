(ns webroti.db
  (:import [java.util UUID]
           [java.util.concurrent.atomic AtomicLong]))

(defprotocol MeetingDatabase
  (new-meeting [this id-generator])
  (get-meeting [this id])
  (update-meeting [this id vote]))

(defn- now [] (System/currentTimeMillis))

(defn- in-memory-update [id vote]
  (fn [map]
    (if-let [e (find map id)]
      (assoc map id (-> (val e) (assoc :updated (now)) (update-in [:votes] conj vote)))
      map)))

(defn- new-meeting-fn [id]
  (fn [map]
    (conj map [id {:created (now) :votes []}])))

(defn create-in-memory-database []
  (let [db (atom {})]
    (reify
      MeetingDatabase
      (new-meeting [this id-generator]
        (let [id (id-generator)]
          (swap! db (new-meeting-fn id))
          id))

      (get-meeting [this id]
        (get @db id))

      (update-meeting [this id vote]
        (let [f (in-memory-update id vote)
              map (swap! db f)]
          (if (find map id) true false))))))

(defn create-uuid-generator []
  (fn []
    (str (UUID/randomUUID))))

(defn create-sequence-generator []
  (let [x (AtomicLong.)]
    (fn []
      (str (.getAndIncrement x)))))
