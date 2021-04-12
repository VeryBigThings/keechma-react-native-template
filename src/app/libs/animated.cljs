(ns app.libs.animated
  (:require
    ["react-native" :as rn :refer [Animated Easing]]
    [oops.core :refer [oget ocall oget+]]
    [camel-snake-kebab.core :refer [->camelCaseString]]
    [camel-snake-kebab.extras :refer [transform-keys]]))

(defn ->js [v]
  (->> v (transform-keys ->camelCaseString) clj->js))

(def Value (oget Animated :Value))
(def View (oget Animated :View))
(def ScrollView (oget Animated :ScrollView))
(def Text (oget Animated :Text))
(def Image (oget Animated :Image))
(def Event (oget Animated :Event))

(defn value [v] (Value. v))

(defn event [mapping]
   (ocall Animated :event mapping))

; (defn event [mapping]
;   (ocall Animated :event mapping #js{:useNativeDriver true}))

(defn timing [value props]
  (ocall Animated :timing value (->js (update props :use-native-driver #(or % false)))))

(defn spring [value props]
  (ocall Animated :spring value (->js props)))

(defn interpolate [animated-value props]
  (let [props' (-> props
                   (update :input-range #(or % [0 1]))
                   (update :output-range #(or % [0 1])))]
    (ocall animated-value :interpolate (->js (update props' :use-native-driver #(or % false))))))

(def constantly-1 (value 1))

(defn start
  ([animation cb]
   (ocall animation :start cb))
  ([animation]
   (ocall animation :start)))

(defmulti easing (fn [easing-type & args]))

(defmethod easing :default [easing-type & _]
  (oget+ Easing (->camelCaseString easing-type)))

(defmethod easing :back [_ val]
  (ocall Easing :back val))

(defmethod easing :elastic [_ val]
  (ocall Easing :elastic val))