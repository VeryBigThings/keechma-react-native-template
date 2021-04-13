(ns app.controllers.app-state
  (:require [keechma.next.controller :as ctrl]
            ["react-native" :refer [AppState]]
            [oops.core :refer [ocall oget]]))

;; App state controller subscribes to app state changes and broadcasts the new state on the key ":app-state/change"
;; more info here: https://reactnative.dev/docs/appstate

(derive :app-state :keechma/controller)

(defn bind-on-app-state-change [cb]
  (ocall AppState :addEventListener "change" cb)
  (fn []
    (ocall AppState :removeEventListener "change" cb)))

(defmethod ctrl/init :app-state [ctrl]
  (let [on-app-state-change #(ctrl/broadcast ctrl :app-state/change (keyword (oget AppState :currentState)))
        unbind-on-app-state-change (bind-on-app-state-change on-app-state-change)]
    (assoc ctrl ::unbind unbind-on-app-state-change)))

(defmethod ctrl/terminate :app-state [ctrl]
  (when-let [unbind (::unbind ctrl)]
    (unbind)))