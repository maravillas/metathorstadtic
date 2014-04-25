(ns metathorstadtic.gen
  (:use [clojure.string :only [capitalize]]))

(defn lookup
  [k]
  (fn [grammar]
    (rand-nth (k grammar))))

(defn cap
  [k]
  (comp capitalize (lookup k)))

(def grammar
  {:noun-word ["horse" "meat"
               "monkey" "hair"
               "beverage" "eagle"
               "dog" "duck"
               "mullet" "bizness"
               "golf" "blubber"
               "thunder" "squid"
               "guts"]

   :identifier [[:noun-word]
                [:noun-word
                 (cap :noun-word)]
                [:noun-word
                 (cap :noun-word)
                 (cap :noun-word)]]

   :snake-identifier [[:noun-word]
                      [:noun-word "_" :noun-word]
                      [:noun-word "_" :noun-word "_" :noun-word]]
   
   :name [[:name-body]
          [:title " " :name-body]
          [:name-body " " :generational]
          [:title " " :name-body " " :generational]]
   :full-name [[(cap :noun-word)]
               [(cap :noun-word)
                " "
                (cap :noun-word)]]
   :name-body [[:full-name]
               [:name-prefix :full-name]
               [:full-name :name-suffix]]
   :title ["Lord" "Sir" "Dr." "Mr."]
   :name-prefix ["Mc"]
   :name-suffix ["son"]
   :generational ["I" "II" "III" "IV"]})

(defn capitalize-tokens
  [tokens]
  (map capitalize tokens))

(declare substitute)

(defn substitute-one
  [grammar pattern]
  (cond (keyword? pattern)
        [((lookup pattern) grammar)]

        (fn? pattern)
        [(pattern grammar)]

        (coll? pattern)
        (substitute grammar pattern)
        
        :else
        [pattern]))

(defn substitute
  [grammar pattern]
  (let [subbed (mapcat #(substitute-one grammar %) pattern)
        finished? (every? string? subbed)]
    (if finished?
      subbed
      (substitute grammar subbed))))

(defn generate
  [product]
  (apply str (substitute grammar [product])))


