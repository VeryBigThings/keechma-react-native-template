(ns app.screens.home
  (:require ["react-native" :refer [Text View TouchableOpacity]]
            [app.libs.helix :refer [$ defnc]]
            [app.libs.navigation :refer [navigate]]
            [keechma.next.helix.core :refer [with-keechma]]))

(defnc Renderer [props]
 ($ View {:style {:flex 1 :justifyContent "center" :alignItems "center"}} 
     ($ Text {:style {:color "black"}} "Hello from Keechma React Native app home!")
     ($ TouchableOpacity {:onPress #(navigate props "settings")}
      ($ Text {:style {:padding 10 :backgroundColor "white" :margin 10}} "Go To Settings"))))
     

 

(def Home (with-keechma Renderer))
