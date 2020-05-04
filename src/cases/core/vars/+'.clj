(ns cases.core.vars.+')

;; Returns the sum of nums. (+') returns 0. Supports arbitrary precision.
;; See also: +
(println "(+')" (+'))
(println "(+' 1)" (+' 1))
(println "(+' -10)" (+' -10))
(println "(+' 1 2)" (+' 1 2))
(println "(+' 1 2 3)" (+' 1 2 3))
(println "(+' 1 Long/MAX_VALUE)" (+' 1 Long/MAX_VALUE))