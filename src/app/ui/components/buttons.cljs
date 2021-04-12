(ns app.ui.components.buttons
  (:require  ["react-native" :as rn :refer [Text ActivityIndicator]]
             ["react-native-gesture-handler" :refer [RectButton]]
             [app.libs.helix :refer [defnc $]]))

(def default-style {:backgroundColor "cornflowerblue"
                    :width 150
                    :height 40
                    :padding 10
                    :align-items "center"
                    :justify-content "center"})
(def default-label-style {:color "white"})
(def disabled-style {:backgroundColor "lightgray"})
(def disabled-label-style {:color "darkgray"})

(defnc LoadingIndicator []
  ($ ActivityIndicator {:color "white"}))


(defnc Primary [{:keys [onPress label loading disabled style label-style]}]
  ($ RectButton
     {:onPress (when (and (not loading) (not disabled)) onPress)
      :enabled (not disabled)
      :activeOpacity 0.2
      :style [default-style
              (when disabled disabled-style)
              style]}
     (if loading
       ($ LoadingIndicator)
       ($ Text {:style [default-label-style
                        (when disabled disabled-label-style)
                        label-style]}
          label))))
