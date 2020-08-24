(ns cases.core.d.double-array
  (:require [cases.aux.title :refer [title]])
  (:import (java.util Arrays)))

;; Creates an array of doubles

;; create a double array using double-array
;; and show it can be used with the standard Java functions
;; binarySearch and fill

;; see
;;   cases.core.r.range
;;   cases.core.t.type
;;   cases.core.v.vec

(title)
(def ds (double-array (range 3 30 3)))
(prn (type ds))
(prn (vec ds))

(title "Test arrays functions")
(def ds2 (double-array (range 3 30 3)))
(Arrays/fill ds2 3 8 99.0)
(Arrays/sort ds2)
(prn (Arrays/binarySearch ds2 27.0))
(prn (vec ds2))