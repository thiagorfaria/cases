(ns cases.core.vars.div)

;; If no denominators are supplied, returns 1/numerator,
;; else returns numerator divided by all of the denominators.
(println "(/ 6 3)" (/ 6 3))
(println "(/ 6 3 2)" (/ 6 3 2))
(println "(/ 10)" (/ 10))
(println "(/ 1 3)" (/ 1 3))