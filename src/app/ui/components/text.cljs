(ns app.ui.components.text
  (:require ["react" :as react]
            ["react-native" :refer [Text]]
            [app.libs.helix :refer [defnc $]]
            [app.libs.utils :refer [is-ios]]))


(defnc P [{:keys [children style on-press]}]
  ($ Text
     {:onPress on-press
      :style [{:font-family (if is-ios "Nunito Sans" "NunitoSans-Regular")
               :line-height 20
               :font-size 16}
              style]}
     children))

(defnc Small [{:keys [children style]}]
  ($ Text
     {:style [{:font-family (if is-ios "Nunito Sans" "NunitoSans-Regular")
               :line-height 18
               :font-size 13}
              style]}
     children))

(defnc Bold [{:keys [children style]}]
  ($ Text
     {:style [{:font-family (if is-ios "Nunito Sans" "NunitoSans-Bold")
               :line-height 22
               :font-size 16
               :font-weight "600"}
              style]}
     children))

(defnc H1 [{:keys [children style]}]
  ($ Text
     {:style [{:font-family (if is-ios "Montserrat" "Montserrat-ExtraBold")
               :line-height 58
               :font-size 48
               :font-weight "800"}
              style]}
     children))

(defnc H2 [{:keys [children style]}]
  ($ Text
     {:style [{:font-family (if is-ios "Montserrat" "Montserrat-ExtraBold")
               :line-height 28
               :font-size 22
               :margin-top 10
               :margin-bottom 10
               :font-weight "800"}
              style]}
     children))

(defnc H3 [{:keys [children style]}]
  ($ Text
     {:style [{:font-family (if is-ios "Montserrat" "Montserrat-Regular")
               :line-height 32
               :font-size 22}
              style]}
     children))

(defnc H4 [{:keys [children style]}]
  ($ Text
     {:style [{:font-family (if is-ios "Montserrat" "Montserrat-Bold")
               :line-height 22
               :font-size 18
               :font-weight "700"}
              style]}
     children))

(defnc Display [{:keys [children style]}]
  ($ Text
     {:style [{:font-family (if is-ios "Montserrat" "Montserrat-Regular")
               :line-height 32
               :font-size 22
               :font-weight "400"}
              style]}
     children))
