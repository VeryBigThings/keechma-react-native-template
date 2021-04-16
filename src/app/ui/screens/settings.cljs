(ns app.ui.screens.settings
  (:require ["react-native" :refer [View]]
            [app.libs.helix :refer [$ defnc]]
            [app.ui.components.inputs :refer [wrapped-input]]
            [app.ui.components.buttons :as buttons]
            [app.ui.components.text :as text]
            [keechma.next.helix.core :refer [with-keechma]]
            [applied-science.js-interop :as j]
            ["@sentry/react-native" :as Sentry]))


(defnc Renderer []
 ($ View {:style {:flex 1 :justifyContent "center" :alignItems "center"}}
    ($ text/H3 {:style {:color "black" :margin 10}} "Hi from settings")

    (wrapped-input {:input/type :text
                    :input/attr "name"
                    :placeholder "First Name"})

    (wrapped-input {:input/type :text
                    :input/attr "surname"
                    :placeholder "Last Name"})
    
    (wrapped-input {:input/type :password
                    :input/attr "password"
                    :placeholder "Password"})
                    
   ($ buttons/Primary {:label "Submit"})
    
   ($ buttons/Primary {:label "Sentry" :onPress #(j/call Sentry :nativeCrash)})))
                     


 

(def Settings (with-keechma Renderer))
