(ns cases.f.ex-filter)

;; Returns a lazy sequence of the items in coll for which
;; (pred item) returns logical true. pred must be free of side-effects.
;; Returns a transducer when no collection is provided.

(println (filter even? (range 10)))

(defn my-even?
  [number]
  (let [x (even? number)
        (println number " even => " x)]
    x))

(println (filter my-even? (range 10)))

(println (filter (fn [x] (= (count x) 1))
                 ["a" "aa" "b" "n" "f" "lisp" "clojure" "q" ""]))