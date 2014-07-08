(ns metathorstadtic.core
  (:require [metathorstadtic.gen :as gen]
            [goog.events :as events]))

(enable-console-print!)

(defn gen
  [e]
  (let [s (gen/generate (keyword (-> e .-target .-dataset .-type)))]
    (set! (.-innerHTML (.getElementById js/document "str")) s)
    (.preventDefault e)))

(doseq [id ["gen-camel" "gen-name" "gen-snake"]]
  (events/listen (.getElementById js/document id)
                 "click"
                 gen))

