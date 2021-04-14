(ns app.ui.screens.splash
  (:require ["react-native" :refer [View Animated Image StyleSheet]]
            ["expo-splash-screen" :as SplashScreen]
            [app.libs.helix :refer [$ defnc]]
            [app.libs.tailwind :refer [tw]]
            [app.libs.navigation :refer [reset]]
            [helix.hooks :as hooks]
            [keechma.next.helix.core :refer [with-keechma]]
            [applied-science.js-interop :as j]
            [app.images :refer [splash-bgn logo]]
            [app.libs.animated :as animated]))

(def duration 600)

(defnc Renderer [props]
  (let [logo-animated-value (hooks/use-ref (animated/value 100))
        animate-logo (hooks/use-ref (animated/timing @logo-animated-value {:duration duration :to-value 0}))]

    (hooks/use-effect :once
                  (js/setTimeout #(j/call SplashScreen :hideAsync) 500)
                  (->
                   (j/call Animated :sequence
                           #js[(j/call Animated :delay 1500)
                               (j/call Animated :stagger 300
                                       #js[@animate-logo])
                               (j/call Animated :delay 200)])

                   (animated/start #(reset props "home"))))

    ($ View {:style [(tw :items-center :justify-center :w-full :h-full)]}
       ($ Image {:style [(tw :h-full :w-full) (j/get StyleSheet :absoluteFill)]
                 :source splash-bgn
                 :resizeMode "cover"})

       ($ animated/View {:style
                         [(tw :justify-center :items-center)
                          {:opacity (animated/interpolate @logo-animated-value {:input-range [0 50 100] :output-range [1 0.5 0]})}]}
          ($ Image {:source logo :style {:width 150 :marginBottom 100} :resizeMode "contain"})))))


(def Splash (with-keechma Renderer))
