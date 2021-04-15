(ns app.libs.utils
  (:require ["react-native" :refer [Platform]]
            [applied-science.js-interop :as j]))

(def is-ios (= "ios" (j/get Platform "OS")))

(def is-android (= "android" (j/get Platform "OS")))
