(ns cases.core.d.doall)

;; When lazy sequences are produced via functions that have side
;; effects, any effects other than those needed to produce the first
;; element in the seq do not occur until the seq is consumed. doall can
;; be used to force any effects. Walks through the successive nexts of
;; the seq, retains the head and returns it, thus causing the entire
;; seq to reside in memory at one time.

(def foot (map println [1 2 3]))
(println (time foot))

(def foo (doall (map println [1 2 3])))
(println (time foo))

(println (time (doall (map println [1 2 3]))))
