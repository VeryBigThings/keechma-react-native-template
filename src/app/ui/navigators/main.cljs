(ns app.ui.navigators.main
  (:require [app.libs.navigation :refer [create-stack-navigator screen navigator]]
            [app.libs.helix :refer [defnc $]]
            [app.ui.screens.home :refer [Home]]
            [app.ui.screens.settings :refer [Settings]]))

(def app-stack (create-stack-navigator))

(def screen-options
  {:headerBackTitleVisible false
   :headerTitleAlign "center"
   :headerTintColor "#000000"
   :headerTitleStyle #js{:color "#000000"}})

(defnc MainNavigator []
  ($ (navigator app-stack)
     {:screenOptions (clj->js screen-options)
      :initialRouteName "home"}

     ($ (screen app-stack)
        {:name "home"
         :component Home})

     ($ (screen app-stack)
        {:name "settings"
         :component Settings})))

