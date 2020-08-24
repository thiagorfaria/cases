(ns cases.core.a.aget
  (:require [cases.aux.title :refer [title]]))

;; Returns the value at the index/indices. Works on Java arrays of all
;; types.

;; see
;;   cases.core.d.double-array
;;   cases.core.i.int-array
;;   cases.core.m.make-array

(title "get an item by index")
(def a1 (double-array '(1.0 2.0 3.0 4.0)))
(def aget-list-double (aget a1 2))
(prn aget-list-double)

(title "testing a get from list of integers")
(def a2 (int-array '(9 8 7 6)))
(def aget-list-int (aget a2 3))
(prn aget-list-int)

(title "2d array and 2 indicies")
(def a3 (make-array Integer/TYPE 2 2))
(def aget-array-2s (aget a3 1 0))
(prn (vec a3))
(prn aget-array-2s)
