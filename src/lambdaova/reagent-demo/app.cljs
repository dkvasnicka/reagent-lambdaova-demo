(ns lambdaova.reagent-demo
  (:require [reagent.core :as reagent :refer [atom render-component]]
            [jayq.core :refer [document-ready ajax]])
  (:require-macros [jayq.macros :as jqm :refer [let-ajax]]))

(def todos (atom (array-map))) ; "text" => done?

(defn list-of-todos []
  [:ul
    (for [t @todos]
      [:li {:key (key t)} 
       [:input (merge
                 {:type "checkbox"
                  :on-click #(swap! todos update-in [(key t)] not)}
                 (when (val t) {:defaultChecked "checked"}))]
       [(if (val t) :i :span) (key t)]
       [:a {:href "#" :on-click #(swap! todos dissoc (key t))} " x "]])])

(defn todo-form []
  (let [todoinput (atom "")]
    (fn []
      [:form
        [:input {:type "text" :on-change #(reset! todoinput (-> % .-target .-value))}]
        [:button {:type "button"
                  :on-click #(swap! todos conj [@todoinput false])} "Add"]])))

(defn application []
  [:div
    [list-of-todos]
    [todo-form]])

(jqm/ready
  (let-ajax [data {:url "/todos.edn" :dataType :edn}]
    (reset! todos data)
    (render-component [application] (.-body js/document))))
