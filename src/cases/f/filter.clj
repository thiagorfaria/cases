(ns cases.f.filter)

;; Returns a lazy sequence of the items in coll for which
;; (pred item) returns logical true. pred must be free of side-effects.
;; Returns a transducer when no collection is provided.

(println (filter even? (range 10)))

(defn my-odd?
  [number]
  (let [even (even? number)
        odd  (not even)]
    (println (str number " even => " even " odd => " odd))
    odd))

(println (filter my-odd? (range 10)))

(println (filter (fn [x] (= (count x) 1))
                 ["a" "aa" "b" "n" "f" "lisp" "clojure" "q" ""]))

(println (filter #(= (count %) 1)
                 ["a" "aa" "b" "n" "f" "lisp" "clojure" "q" ""]))