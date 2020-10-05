(ns cases.core.p.partition-all)

;; Returns a lazy sequence of lists like partition, but may include
;; partitions with fewer than n items at the end.  Returns a stateful
;; transducer when no collection is provided.

(prn (partition 4 [0 1 2 3 4 5 6 7 8 9]))

(prn (partition-all 4 [0 1 2 3 4 5 6 7 8 9]))

(prn (partition-all 2 3 [0 1 2 3 4 5 6 7 8 9 10 11 12]))
