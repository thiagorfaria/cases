(ns cases.core.a.alength
  (:require [cases.aux.title :refer :all]))

;; Returns the length of the Java array. Works on arrays of all
;; types.

;; see
;;   cases.core.i.into-array
;;   cases.core.t.to-array-2d

(title)
(def my-array (into-array Integer/TYPE [1 2 3]))
(def my-array-length (alength my-array))
(prn my-array-length)

(title "2D simple array example")
(def my-array-2d (to-array-2d [[1 2] [3 4 5] [1] [7 8 9]]))
(def my-array-2d-length (alength my-array-2d))
(prn my-array-2d-length)
