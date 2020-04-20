(ns cases.core.m.max)

; Returns the greatest of the nums.

;; `max` returns the largest of its arguments
(println (max 1 2 3 4 5))
;; regardless of order of those arguments
(println (max 5 4 3 2 1))
(println (max 100))
(println (apply max [1 2 3 4 3]))
(println (apply max '(4 3 5 6 2)))
(println (reduce max [1 2 3 4 5 6 7 6 5 4 3]))

