(ns app.app
  (:require ["react" :as react]
            [shadow.react-native :refer (render-root)]
            [app.main :refer [Root]]
            [keechma.next.core :as keechma]
            [keechma.next.helix.core :refer [KeechmaRoot]]
            [helix.core :refer [defnc $]]
            [app.keechma-app :refer [app]]))

(defonce app-instance* (atom nil))

(defn reload
  {:dev/after-load true}
  []
  (when-let [app-instance @app-instance*]
    (keechma/stop! app-instance))
  (let [app-instance (keechma/start! app)]
    (reset! app-instance* app-instance)
    (render-root "keechmaRNApp"($ KeechmaRoot {:keechma/app app-instance} ($ Root)))))

(defn init []
  (reload))
