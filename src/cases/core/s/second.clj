(ns cases.core.s.second)

;; Same as (first (next x))

(prn "'(:alpha :bravo :charlie)" (second '(:alpha :bravo :charlie)))
(prn "{:a 1 :b 2 :c 3}" (second {:a 1 :b 2 :c 3}))
(prn "#{1 2 3}" (second #{1 2 3}))
(prn "[1 2]" (second [1 2]))
(prn "[1]" (second [1]))
(prn "[]" (second []))
(prn "nil" (second nil))