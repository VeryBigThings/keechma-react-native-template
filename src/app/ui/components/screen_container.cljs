(ns app.ui.components.screen-container
  (:require ["react-native" :refer [View]]
            [app.libs.helix :refer [$ defnc]]
            [app.libs.tailwind :refer [tw]]
            [app.libs.hooks :refer [use-safe-area use-dimensions]]))

(defnc ScreenContainer [{:keys [children style] :as props}]
  (let [insets (use-safe-area)]
    ($ View {:style [(tw :h-full) 
                     (when (:bottom-inset props) {:padding-bottom (:bottom insets)})
                     (when (:top-inset props) {:padding-top (:top insets)})
                     style]}
       children)))
