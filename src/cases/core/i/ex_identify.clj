(ns cases.core.i.ex_identify)

;; Returns its argument.

(println (identity 4))
(println (filter identity [1 2 3 nil 4 false true 1234]))
(println (map #(%1 %2) (cycle [inc identity]) [1 2 3 4 5 6 7 8 9 10]))
(println (partition-by identity (sort "abcdaabccc")))
(println (map first (partition-by identity [1 1 2 3 3 1 1 5 5])))
(println (group-by identity "abracadabra"))
