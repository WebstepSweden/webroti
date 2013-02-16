(defproject webroti-clojure "0.1.0-SNAPSHOT"
  :description "webroti application in clojure"
  :url "http://www.diversify.se/"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.5"]
                 [ring/ring-json "0.1.2"]]
  :plugins [[lein-ring "0.8.2"]]
  :ring {:handler webroti.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
