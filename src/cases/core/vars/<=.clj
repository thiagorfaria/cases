(ns cases.core.vars.<=)

;; Returns non-nil if nums are in monotonically non-decreasing order,
;; otherwise false.
(println "(<= 1 2)" (<= 1 2))
(println "(<= 2 1)" (<= 2 1))
(println "(<= 1.5 2)" (<= 1.5 2))
(println "(<= 2 3 4 4 5 6 6)" (<= 2 3 4 4 5 6 6))