(ns app.ui.navigators.main
  (:require ["react-native" :refer [View StyleSheet]]
            [app.libs.navigation :refer [create-stack-navigator screen navigator]]
            [app.libs.helix :refer [defnc $]]
            [app.libs.tailwind :refer [tw]]
            [app.ui.screens.home :refer [Home]]
            [app.ui.screens.splash :refer [Splash]]
            [app.ui.screens.settings :refer [Settings]]
            [applied-science.js-interop :as j]))

(def app-stack (create-stack-navigator))

(def screen-options
  {:headerBackTitleVisible false
   :headerTitleAlign "center"
   :headerTintColor "#000000"
   :headerTitleStyle #js{:color "#000000"}})

(defnc MainNavigator []
  ($ View {:style [(j/get StyleSheet :absoluteFill) (tw :bg-white)]}
     ($ (navigator app-stack)
        {:screenOptions (clj->js screen-options)
         :initialRouteName "splash"}

        ($ (screen app-stack)
           {:name "splash"
            :component Splash
            :options #js{:headerShown false}})

        ($ (screen app-stack)
           {:name "home"
            :component Home})

        ($ (screen app-stack)
           {:name "settings"
            :component Settings}))))

