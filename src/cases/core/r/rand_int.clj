(ns cases.core.r.rand-int
  (:require [clojure.set :as set]))

;; Returns a random integer between 0 (inclusive) and n (exclusive).
(println (rand-int 30))
(println (int (rand 30)))

; random generation of unique series of random numbers from 0 to n-1
(defn unique-random-numbers [n]
  (let [a-set (set (take n (repeatedly #(rand-int n))))]
    (concat a-set (set/difference (set (take n (range)))
                                  a-set))))

(unique-random-numbers 20)