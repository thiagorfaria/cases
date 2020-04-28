(ns cases.core.c.concat)

;; Returns a lazy seq representing the concatenation of the elements in the supplied colls.
(println (concat [1 2] [3 4]))
(println (into [] (concat [1 2] [3 4])))
(println (concat [:a :b] nil [1 [2 3] 4]))
(println (concat [1] [2] '(3 4) [5 6 7] #{9 10 8}))

(println (concat "abc" "def"))
(println (apply concat '(([1 2]) ([3 4] [5 6]) ([7 8]))))
(println (concat '(1 2 3) '(4 5 6)))
(println (concat {:a "A" :b "B" :c "C"} {:d "D" :e "E"}))
(defn padding-right [s width pad]
  (apply str (take width (concat s (repeat pad)))))
(println (padding-right "Clojure" 10 " "))
(println (conj (concat [1 2] [3 4]) 5))