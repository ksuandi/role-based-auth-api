(ns role-based-auth-api.routes.test
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s]))

(s/defschema Pizza
  {:name s/Str
   (s/optional-key :description) s/Str
   :size (s/enum :L :M :S)
   :origin {:country (s/enum :FI :PO)
            :city s/Str}})

(def test-routes
  (context "/api/v1/test" []
    :tags ["test"]

    (GET "/plus" []
      :return {:result Long}
      :query-params [x :- Long, y :- Long]
      :summary "adds two numbers together"
      (ok {:result (+ x y)}))

    (POST "/echo" []
      :return Pizza
      :body [pizza Pizza]
      :summary "echoes a Pizza"
      (ok pizza))

    (GET "/auth" []
      :auth-roles #{"any"}
      :current-user user
      :summary "Test token - response 200 only when authorizated"
      (ok user))
))
