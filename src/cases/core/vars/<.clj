(ns cases.core.vars.<)

;; Returns non-nil if nums are in monotonically increasing order,
;; otherwise false.
(println "(< 1 2)" (< 1 2))
(println "(< 2 1)" (< 2 1))
(println "(< 1.5 2)" (< 1.5 2))
(println "(< 2 3 4 5 6)" (< 2 3 4 5 6))