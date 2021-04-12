(ns app.ui.screens.home
  (:require ["react-native" :refer [Text View TouchableOpacity]]
            [app.libs.helix :refer [$ defnc]]
            [app.libs.navigation :refer [navigate]]
            [app.ui.components.buttons :as buttons]
            [keechma.next.helix.core :refer [with-keechma]]))

(defnc Renderer [props]
 ($ View {:style {:flex 1 :justifyContent "center" :alignItems "center"}} 
     ($ Text {:style {:color "black"}} "Hello from Keechma React Native app home!")
     ($ TouchableOpacity {:onPress #(navigate props "settings")}
      ($ Text {:style {:padding 10 :backgroundColor "white" :margin 10}} "Go To Settings"))

     ($ buttons/Primary {:label "Primary Button" :onPress #(navigate props "settings") :style {:margin 5}})
     ($ buttons/Primary {:label "Disabled Button" :onPress #(navigate props "settings") :disabled true :style {:margin 5}})
     ($ buttons/Primary {:label "Primary Button" :onPress #(navigate props "settings") :style {:margin 5} :loading true})))


 

(def Home (with-keechma Renderer))
