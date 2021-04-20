(ns app.libs.hooks
  (:require ["react-native-safe-area-context" :refer [useSafeArea]]
            ["react-native" :refer [useWindowDimensions]]
            [applied-science.js-interop :as j]
            [cljs-bean.core :refer [->clj]]))

(defn use-safe-area []
  (->clj (useSafeArea)))

(defn use-dimensions [dimension]
  (j/get (useWindowDimensions) (name dimension)))
