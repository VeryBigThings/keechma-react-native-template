(ns app.ui.screens.settings
  (:require ["react-native" :refer [Text View]]
            [app.libs.helix :refer [$ defnc]]
            [keechma.next.helix.core :refer [with-keechma]]))


(defnc Renderer []
 ($ View {:style {:flex 1 :justifyContent "center" :alignItems "center"}} 
     ($ Text {:style {:color "black"}} "Hi from settings")))
 

(def Settings (with-keechma Renderer))
