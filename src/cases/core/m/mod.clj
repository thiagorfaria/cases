(ns cases.core.m.mod)

;; Modulus of num and div. Truncates toward negative infinity.
(println (mod 10 5))
(println (mod 10 6))
(println (mod 10 10))
(println (mod 10 -1))
(println (mod -2 5))
(println (mod -10 3))
(println (rem -10 3))
(println (mod 10 -3))
(println (mod -10 -3))
(println (mod 10 3))