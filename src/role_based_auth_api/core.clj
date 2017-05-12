(ns role-based-auth-api.core
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [role-based-auth-api.routes.auth :refer [auth-routes]]
            [role-based-auth-api.routes.test :refer [test-routes]])) ;

(def app
  (api
    {:swagger
     {:ui "/api/v1/docs"
      :spec "/swagger.json"
      :data {:info {:title "Compojure API with role-based authorization"
                    :description "Some description"}
             :tags [{:name "test" :description "Test routes"}
                    {:name "auth" :description "Auth routes"}]
             ;; Adds field to Swagger-UI to provide the value for Authorization header
             :securityDefinitions {:api_key {:type "apiKey" :name "Authorization" :in "header"}}
             }}}

    test-routes
    auth-routes))
