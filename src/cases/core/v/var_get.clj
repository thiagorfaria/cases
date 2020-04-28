(ns cases.core.v.var-get)

;; Gets the value in the var object

(println map)
(println #'map)
(println (var-get #'map))

(println ((var-get (var inc)) 1))

(with-local-vars [x 10]
  (println x)
  (println @x)
  (println (var-get x)))