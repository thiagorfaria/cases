(ns cases.my.destructing)

;; Destructing vector
(def my-vector [1 2 3 4 5 6])
(println my-vector)

(let [[one two three _ five six] my-vector]
  (println one two three five six))

(defn print-numbers [[one _ _ four _ six]]
  (println one four six))

(print-numbers my-vector)
(println)

;; Destructing list
(def my-list (list :a :b "c" 'd))
(prn my-list)

(let [[a b c d e] my-list]
  (prn a b c d e))

(defn print-letter [[a _ c]]
  (prn a c))

(print-letter my-list)
(println)

;; Destructing map
(def my-map {:a 1 :b 2 :c {:ca 3 :cb 4}})
(println my-map)

(let [{a :a b :b {cb :cb} :c} my-map]
  (println a b cb))

(def artist-map {:painter :monet :novelist :austen})
(let [{x :painter y :novelist} artist-map]
  (println "The painter is" x)
  (println "The novelist is" y)
  (println))

;; Destructing map with vectors

(def my-map2 {:a 1 :b 2 :c {:ca 3 :cb [1 2 3 4 5]}})
(println my-map2)

;; Keys
(def james {:name "James" :age 33 :gender :male :country "Brazil"})

(defn person-information [{:keys [name age gender]
                           :or {name "" age 0 gender :none}
                           :as info}]
  (prn info)
  (prn (:country info))
  (prn name age gender))

(person-information {})
(person-information james)