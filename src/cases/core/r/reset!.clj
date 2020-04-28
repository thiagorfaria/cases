(ns cases.core.r.reset!)

;; Sets the value of atom to newval without regard for the
;; current value. Returns newval.

(def x (atom 10))
(println x)
(println @x)
(reset! x 20)
(println x)
(println @x)