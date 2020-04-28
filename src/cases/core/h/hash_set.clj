(ns cases.core.h.hash-set)

;; Returns a new hash set with supplied keys.  Any equal keys are
;; handled as if by repeated uses of conj.

(prn (hash-set 1 2 1 3 1 4 1 5))
(prn (= (hash-set :c :a :b) #{:b :a :c}))
(prn (apply hash-set (seq "Lorem ipsum dolor sit amet")))
(prn (set "Lorem ipsum dolor sit amet"))