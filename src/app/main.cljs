(ns app.main
  (:require ["react-native-safe-area-context" :refer [SafeAreaProvider]]
            ["@react-navigation/native" :refer [NavigationContainer]]
            ["expo-splash-screen" :as SplashScreen]
            [shadow.react-native :refer (render-root)]
            [helix.hooks :as hooks]
            [applied-science.js-interop :as j]
            [keechma.next.core :as keechma]
            [keechma.next.helix.core :refer [with-keechma dispatch KeechmaRoot]]
            [app.libs.helix :refer [$ defnc]]
            [app.keechma-app :refer [app]]
            [app.ui.navigators.main :refer [MainNavigator]]))

(defonce router-state (atom nil))

(j/call SplashScreen :preventAutoHideAsync)

(defnc RootRenderer [props]
  (let [navigation-ref* (hooks/use-ref nil)]
    ($ NavigationContainer
       {:onStateChange (fn [state]
                         (reset! router-state state)
                         (dispatch props :router :route-change state))
        :onReady #(dispatch props :router :register-navigator @navigation-ref*)
        :ref navigation-ref*
        :initialState @router-state
        :theme (clj->js {:colors {:background "#f9f9f9"}})}

       ($ MainNavigator))))

(def Root (with-keechma RootRenderer))

(defonce app-instance* (atom nil))

(defn reload
  {:dev/after-load true}
  []
  (when-let [app-instance @app-instance*]
    (keechma/stop! app-instance))
  (let [app-instance (keechma/start! app)]
    (reset! app-instance* app-instance)
    (render-root "keechmaRNApp"($ KeechmaRoot {:keechma/app app-instance}
                                  ($ SafeAreaProvider
                                     ($ Root)))))) 

(defn init []
  (reload))

