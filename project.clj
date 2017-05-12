(defproject role-based-auth-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.8.0"]

                 ;; web
                 [metosin/compojure-api "1.2.0-alpha5"]

                 ;; crypto
                 [buddy/buddy-core "1.2.0"]

                 ;; db
                 [yesql "0.5.3"]
                 [mysql/mysql-connector-java "6.0.5"]
                 [com.mchange/c3p0 "0.9.5.2"]

                 ;; log
                 [com.taoensso/timbre "4.8.0"]]

  :ring {:handler role-based-auth-api.core/app}
  :uberjar-name "server.jar"
  :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]]
                   :plugins [[lein-ring "0.10.0"]]}})
