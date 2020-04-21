(ns cases.core.vars.>)

;; Returns non-nil if nums are in monotonically decreasing order,
;; otherwise false.
(println "(> 1 2)" (> 1 2))
(println "(> 2 1)" (> 2 1))
(println "(> 2 2)" (> 2 2))
(println "(> 6 5 4 3 2)" (> 6 5 4 3 2))
(println "(sort > (vals {:foo 5, :bar 2, :baz 10}))" (sort > (vals {:foo 5, :bar 2, :baz 10})))