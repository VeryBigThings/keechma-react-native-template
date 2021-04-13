(ns app.ui.components.inputs
  (:require ["react-native" :refer [View TextInput Text Animated TouchableOpacity]]
            [keechma.next.helix.core :refer [with-keechma use-meta-sub dispatch]]
            [keechma.next.controllers.form :as form]
            [app.libs.helix :refer [$ defnc]]
            [app.libs.validators :refer [get-validator-message]]
            [app.libs.tailwind :refer [tw]]

            [helix.hooks :as hooks]))

;; default styles
(def input-style [(tw :bg-white :p-1 :m-1)
                  {:width 150
                   :borderWidth 0.5
                   :textAlignVertical "center"
                   :includeFontPadding false}])

(defn get-element-props
  [default-props props]
  (let [element-props (into {} (filter (fn [[k v]] (simple-keyword? k)) props))]
    (reduce-kv
     (fn [m k v]
       (let [prev-v (get k m)
             val (cond (and (fn? prev-v) (fn? v))
                       (fn [& args] (apply prev-v args) (apply v args))
                       (and (= :class k) (:class m)) (flatten [v (:class m)])
                       :else v)]
         (assoc m k val)))
     default-props
     element-props)))


;; ERRORS
(defnc ErrorsRenderer [{:keechma.form/keys [controller]
                        :input/keys        [attr]
                        :as                props}]
  (let [errors-getter (hooks/use-callback [attr] #(form/get-errors-in % attr))
        errors (use-meta-sub props controller errors-getter)]
    (when-let [errors' (get-in errors [:$errors$ :failed])]
      ($ View {:style [(tw :text-red :w-full :font-bold :text-sm)]}
         (map-indexed (fn [i e] ($ Text {:key i
                                         :style [(tw :text-red)]} 
                                   (get-validator-message e)))
                      errors')))))

(def Errors (with-keechma ErrorsRenderer))



;; TEXT
(defnc TextInputRenderer [{:keechma.form/keys [controller]
                           :input/keys        [attr]
                           :as                props}]
  (let [element-props (get-element-props {} props)
        value-getter (hooks/use-callback [attr] #(form/get-data-in % attr))
        value (use-meta-sub props controller value-getter)]

    ($ TextInput
       {:value (str value)
        :placeholder (:placeholder element-props)
        :style [input-style]
        :onChangeText #(dispatch props controller :keechma.form.on/change {:value % :attr attr})
        & element-props})))

(def InputText (with-keechma TextInputRenderer))

;; PASSWORD
(defnc PasswordInputRenderer [{:keechma.form/keys [controller]
                               :input/keys        [attr]
                               :as                props}]
  (let [element-props (get-element-props {} props)
        value-getter (hooks/use-callback [attr] #(form/get-data-in % attr))
        value (use-meta-sub props controller value-getter)
        [password? set-password] (hooks/use-state true)]
    ($ View
       ($ TouchableOpacity {:style [{:position "absolute" :zIndex 1 :right 5 :top 0 :bottom 0 :justifyContent "center"}]
                            :onPress #(set-password (not password?))}
          ($ Text {:style {:fontSize 12}} (if password? "Show" "Hide")))

       ($ TextInput
          {:value (str value)
           :secureTextEntry password?
           :placeholder (:placeholder element-props)
           :style [input-style]
           :onChangeText #(dispatch props controller :keechma.form.on/change {:value % :attr attr})
           & element-props}))))

(def InputPassword (with-keechma PasswordInputRenderer))


(defmulti input (fn [props] (:input/type props)))
(defmethod input :text [props] ($ InputText {& props}))
(defmethod input :password [props] ($ InputPassword {& props}))


(defmulti wrapped-input (fn [props] (:input/type props)))
(defmethod wrapped-input :default [props] (input props))
(defmethod wrapped-input :text [props]
  ($ View
     (input props)
     ($ Errors {& props})))

(defmethod wrapped-input :password [props]
  ($ View
     (input props)
     ($ Errors {& props})))
