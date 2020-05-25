(ns getting.chapter13.records-and-protocols)

;; ## The trouble with maps
(println "## The trouble with maps")

(defn get-watson-1 [] {:name "John Watson" :appears-in "Sing of the four" :author "Doyle"})
(defn get-watson-2 [] {:cpu "Power7" :no-cpus 2880 :storage-gb 4000})

(let [watson-1 (get-watson-1)
      watson-2 (get-watson-2)]
  (prn watson-1)
  (prn watson-2))

;; ## Striking a more specific bargain with records
(println)
(println "## Striking a more specific bargain with records")

(defrecord FictionalCharacter [name appears-in author])

(def watson (->FictionalCharacter "John Watson" "Sign of the four" "Doyle"))
(prn watson)

(def elizabeth (map->FictionalCharacter {:name "Elizabeth Bennet" :appears-in "Pride & Prejudice" :author "Austen"}))
(prn elizabeth)