(ns web.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cheshire.core :as json]))

(defroutes app-routes
           "app routes define the api routes. when we use
           theses apis, we can do a lot things."
           (GET "/" [] "Hello, World!")
           (GET "/cheshire-cat" []
             {:status  200
              :headers {"Content-type" "application/json; charset=utf-8"}
              :body    (json/generate-string
                         {:name   "Cheshire  Cat"
                          :status :grining})})
           (route/not-found "Not Found"))

(def app
  "It is a app for test ring plugin."
  (wrap-defaults app-routes site-defaults))


