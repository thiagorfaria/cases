(ns cases.i.ex-int-array)

;Creates an array of ints

;; if you have a sequence, perhaps lazy, int-array will figure out the size
(println (aget (int-array [1 2 3]) 1))
(println (int-array [1 2 3]))

;; if you need a certain size, with a constant initial value
(def int-array-const (int-array 5 1))
(println (aget int-array-const 4))
(println (count int-array-const))

(def int-array-const-empty (int-array 5))
(println (alength int-array-const-empty))
(println (count int-array-const-empty))

;; finally, you can specify a size + a sequence, which will initialize the array
;; by taking size from the sequence
(def int-array-range (int-array 5 (range 10)))
(println (vec int-array-range))
(println (alength int-array-const-empty))

;; which is equivalent to
(println (alength (int-array (take 5 (range 10)))))