(ns cases.core.f.flatten)


;; Takes any nested combination of sequential things (lists, vectors,
;; etc.) and returns their contents as a single, flat lazy sequence.
;; (flatten nil) returns an empty sequence

(prn (flatten [1 [2 3]]))
(prn (flatten '(1 2 3)))
(prn (flatten '(1 2 [3 (4 5)])))
(prn (flatten nil))
(prn (flatten 5))
(prn (seq {:name "Hubert" :age 23}))
(prn (seq [1 2 3 4]))
(prn (flatten (seq {:name "Hubert" :age 23})))
(prn (flatten {:name "Hubert" :age 23}))