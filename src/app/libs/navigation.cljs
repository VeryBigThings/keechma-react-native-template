(ns app.libs.navigation
  (:require ["@react-navigation/stack" :refer [createStackNavigator]]
            [oops.core :refer [oget ocall]]))

(def create-stack-navigator createStackNavigator)

(defn screen [stack]
  (oget stack :Screen))

(defn navigator [stack]
  (oget stack :Navigator))

(defn navigate
  ([props target]
   (ocall (:navigation props) :navigate target))
  ([props target params]
   (ocall (:navigation props) :navigate target params)))

(defn back [props]
  (ocall (:navigation props) :goBack))
