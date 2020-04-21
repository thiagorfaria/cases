(ns cases.core.vars.==)

;; Returns non-nil if nums all have the equivalent
;; value (type-independent), otherwise false
(println "(== 1)" (== 1))
(println "(== 1 1)" (== 1 1))
(println "(== 1 2)" (== 1 2))
(println "(== 1 1 1)" (== 1 1 1))
(println "(== 1 1 2)" (== 1 1 2))
(println "(= 0.0 0)" (= 0.0 0))
(println "(== 0.0 0)" (== 0.0 0))
(println "(== 2.0 1.9999999999999999)"  (== 2.0 1.9999999999999999))
