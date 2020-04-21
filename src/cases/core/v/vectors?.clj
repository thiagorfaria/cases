(ns cases.core.v.vectors?)

;; Return true if x implements IPersistentVector
;; this is the idiomatic vector
(println "(vector? [1 2 3])" (vector? [1 2 3]))
(println "(vector? '(1 2 3))" (vector? '(1 2 3)))
(println  (type '(1 2 3)))
(println "(vector? (vec '(1 2 3)))" (vector? (vec '(1 2 3))))
(println "(vector? {:a 1 :b 2 :c 3})" (vector? {:a 1 :b 2 :c 3}))
(println "(vector? #{:a :b :c})" (vector? #{:a :b :c}))
(println "(first {:a 1 :b 2 :c 3})" (first {:a 1 :b 2 :c 3}))
(println (type (first {:a 1 :b 2 :c 3})))
(println "(vector? (first {:a 1 :b 2 :c 3}))" (vector? (first {:a 1 :b 2 :c 3})))
(println "(vector? '[])" (vector? '[]))