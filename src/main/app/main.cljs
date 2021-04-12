(ns app.main
  (:require [helix.core :refer [$ defnc]] ;;find these in keechma helix lib?
            ["react-native" :refer [View Text]]))

(defnc Root []
  ($ View {:style #js{:flex 1 :justifyContent "center" :alignItems "center" :backgroundColor "maroon"}}
    ($ Text {:style #js{:color "white"}} "Hello from Keechma React Native app!")))
