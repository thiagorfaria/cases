(ns cases.core.f.filterv)

;; Returns a vector of the items in coll for which
;; (pred item) returns logical true. pred must be free of side-effects.

(println (filterv even? (range 10)))

(println (filterv (fn [x]
                    (= (count x) 1))
                  ["a" "aa" "b" "n" "f" "lisp" "clojure" "q" ""]))

(println (filterv #(= (count %) 1)
                  ["a" "aa" "b" "n" "f" "lisp" "clojure" "q" ""]))
