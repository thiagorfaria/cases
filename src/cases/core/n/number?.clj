(ns cases.core.n.number?)

;; Returns true if x is a Number
(println "(number? 1)" (number? 1))
(println "(number? 1.0)" (number? 1.0))
(println "(number? :a)" (number? :a))
(println "(number? nil)" (number? nil))
(println "(number? \"23\")" (number? "23"))