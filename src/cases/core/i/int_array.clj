(ns cases.core.i.int-array
  (:require [cases.aux.title :refer :all]))

;; Creates an array of ints

;; if you have a sequence, perhaps lazy, int-array will figure out the size

;; see
;;   cases.core.a.aget
;;   cases.core.a.alength
;;   cases.core.c.count
;;   cases.core.r.range
;;   cases.core.t.take
;;   cases.core.v.vec

(def my-array (int-array [1 2 3]))
(prn (vec my-array))
(prn (aget my-array 1))

(title "if you need a certain size, with a constant initial value")
(def int-array-const (int-array 5 1))
(prn (vec int-array-const))
(prn (aget int-array-const 4))
(prn (count int-array-const))


(title "finally, you can specify a size + a sequence, which will initialize the array"
       "by taking size from the sequence")
(def int-array-const-default (int-array 5))
(prn (vec int-array-const-default))
(prn (alength int-array-const-default))
(prn (count int-array-const-default))

(title "finally, you can specify a size + a sequence, which will initialize the array"
       "by taking size from the sequence")
(def int-array-range (int-array 5 (range 10)))
(prn (vec int-array-range))
(prn (alength int-array-const-default))

(title "which is equivalent to")
(prn (alength (int-array (take 5 (range 10)))))