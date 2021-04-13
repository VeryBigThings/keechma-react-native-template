(ns app.ui.screens.settings
  (:require ["react-native" :refer [Text View]]
            [app.libs.helix :refer [$ defnc]]
            [app.libs.tailwind :refer [tw]]
            [app.ui.components.inputs :refer [wrapped-input]]
            [app.ui.components.buttons :as buttons]
            [keechma.next.helix.core :refer [with-keechma]]))
            


(defnc Renderer []
 ($ View {:style {:flex 1 :justifyContent "center" :alignItems "center"}}
    ($ Text {:style {:color "black" :margin 10}} "Hi from settings")

    (wrapped-input {:input/type :text
                    :input/attr "name"
                    :placeholder "First Name"})

    (wrapped-input {:input/type :text
                    :input/attr "surname"
                    :placeholder "Last Name"})
    
    (wrapped-input {:input/type :password
                    :input/attr "password"
                    :placeholder "Password"})
                    
   ($ buttons/Primary {:label "Submit"})))
                     


 

(def Settings (with-keechma Renderer))
