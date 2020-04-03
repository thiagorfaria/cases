(ns cases.l.last)

;; Return the last item in coll, in linear time

(println (last [1 2 3 4 5]))
(println (last ["a" "b" "c" "d" "e"]))
(def map-number {:two 2 :three 3 :one 1})
(println (str (sort-by val map-number)))
(println (last (sort-by val map-number)))

;; but be careful with what you expect from a map (or set):
(def map-alphabetic {:a 1 :b 2 :c 3 :d 4 :e 5 :f 6 :g 7 :h 8 :i 9})
(println (str (sort-by val map-alphabetic)))
(println (last (sort-by val map-alphabetic)))
