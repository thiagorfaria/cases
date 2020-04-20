(ns cases.core.d.double-array
  (:import [java.util Arrays]))

;; Creates an array of doubles

;; create a double array using double-array
;; and show it can be used with the standard Java functions
;; binarySearch and fill

(def ds (double-array (range 3 60 3)))
(println (type ds))
(println (vec ds))
(println (Arrays/binarySearch ds 27.0))
(println (Arrays/fill ds 3 8 99.0))
(println (vec ds))