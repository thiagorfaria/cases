(ns cases.core.v.var-set)

;; Sets the value in the var object to val. The var must be
;;
;; thread-locally bound.

(with-local-vars [x nil]
  (println @x)
  (println x)
  (var-set x 1)
  (println @x)
  (println (var-get x))
  (println x))