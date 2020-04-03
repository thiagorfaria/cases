(ns cases.a.a-get
  (:require [cases.document :as js]))

;; Returns the value at the index/indices. Works on Java arrays of all
;; types.

;; create two arrays
(def a1 (double-array '(1.0 2.0 3.0 4.0)))
(def a2 (int-array '(9 8 7 6)))

;; get an item by index
(println (aget a1 2))
(println (aget a2 3))

;; 2d array and 2 indicies
(def a3 (make-array Integer/TYPE 2 2))
(println (vec a3))
(println (aget a3 1 0))


;; aget can be used to check the existence of an element
;; this approach works with documents in ClojureScript where core/contains? does not
;???? (aget js/document 1)
(contains? js/document 1)
