(ns cases.core.c.constantly)

;; Returns a function that takes any number of arguments and returns x.

(def boring (constantly 10))
(println (boring 1 2 3))
(println (boring))
(println (constantly "Is anybody home?"))

(println (map (constantly 9) [1 2 3]))
(println (map (constantly (rand-int 100)) [:a :b :c]))