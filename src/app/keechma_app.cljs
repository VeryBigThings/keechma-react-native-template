(ns app.keechma-app
  (:require [keechma.next.controllers.dataloader]
            [keechma.next.controllers.entitydb]
            [app.controllers.app-state]
            [app.controllers.router]))
            
(def app
  {:keechma/controllers
   {:app-state
    #:keechma.controller{:params true}
    
    :router
    #:keechma.controller{:params true}}})
