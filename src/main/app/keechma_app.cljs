(ns app.keechma-app
  (:require [keechma.next.controllers.dataloader]
            [keechma.next.controllers.entitydb]
            [app.controllers.test]))
            
(def app
  {:keechma/controllers
   {:test
    #:keechma.controller{:params true}}})
