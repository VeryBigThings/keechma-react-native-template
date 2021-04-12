(ns app.controllers.test
  (:require [keechma.next.controller :as ctrl]
            [keechma.next.controllers.pipelines :as pipelines]
            [keechma.next.controllers.entitydb :as edb]
            [keechma.pipelines.core :as pp :refer-macros [pipeline!]]))

(derive :test ::pipelines/controller)

(def pipelines
  {:keechma.on/start
   (pipeline! [_ ctrl] (println "ctrl started"))

   :keechma.on/stop
   (pipeline! [_ ctrl] (println "ctrl stopped"))})

(defmethod ctrl/prep :test [ctrl]
  (pipelines/register ctrl pipelines))