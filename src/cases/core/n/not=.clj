(ns cases.core.n.not=)

;; Same as (not (= obj1 obj2))
(println "(not= 1 1)" (not= 1 1))
(println "(not= 1 2)" (not= 1 2))
(println "(not= true true)" (not= true true))
(println "(not= true false)" (not= true false))
(println "(not= true true true true)" (not= true true true true))
(println "(not= true true false true)" (not= true true false true))
