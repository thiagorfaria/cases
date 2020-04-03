(ns cases.d.doto
  (:import [java.util HashMap])
  (:use clojure.pprint))

;; Evaluates x then calls all of the methods and functions with the
;; value of x supplied at the front of the given arguments.  The forms
;; are evaluated in order.  Returns x.
;;  (doto (new java.util.HashMap) (.put "a" 1) (.put "b" 2))
;; Note that even though println returns nil, doto still returns the HashMap object
(doto (HashMap.)
  (.put "a" 1)
  (.put "b" 2)
  (println)
  (pprint))

;; Equivalent to
(def m (HashMap.))
(.put m "a" 1)
(.put m "b" 2)
(println m)
(pprint m)