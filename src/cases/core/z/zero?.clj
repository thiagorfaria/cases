(ns cases.core.z.zero?)

;; Returns true if num is zero, else false

(prn "0" (zero? 0))
(prn "0.0" (zero? 0.0))
(prn "2r000" (zero? 2r000))
(prn "0x0" (zero? 0x0))
(prn "1" (zero? 1))
(prn "3.14159265358M" (zero? 3.14159265358M))
(prn "(/ 1 2)" (zero? (/ 1 2)))

(try
  (zero? nil)
  (catch Exception e (prn (.getMessage e))))

(try
  (zero? :a)
  (catch Exception e (prn (.getMessage e))))
