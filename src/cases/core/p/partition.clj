(ns cases.core.p.partition)

;; Returns a lazy sequence of lists of n items each, at offsets step
;; apart. If step is not supplied, defaults to n, i.e. the partitions
;; do not overlap. If a pad collection is supplied, use its elements as
;; necessary to complete last partition upto n items. In case there are
;; not enough padding elements, return a partition with less than n items.

;; partition a list of 20 items into 5 (20/4) lists of 4 items
(def from0->19 (range 20))
(println from0->19)
(println "4" (partition 4 from0->19))

;; partition a list of 22 items into 5 (20/4) lists of 4 items
;; the last two items do not make a complete partition and are dropped.
(println "4" (partition 4 (range 22)))

;; uses the step to select the starting point for each partition
(println "4 6" (partition 4 6 from0->19))

;; if the step is smaller than the partition size, items will be reused
(println "4 3" (partition 4 3 from0->19))

;; when there are not enough items to fill the last partition, a pad can be supplied.
(println "3 6 [\"a\"]" (partition 3 6 ["a"] from0->19))

;; when a pad is supplied, the last partition may not be of the same size as the rest
(println "4 6 [\"a\"]" (partition 4 6 ["a"] from0->19))

;; but only as many pad elements are used as necessary to fill the final partition.
(println "4 6 [\"a\" \"b\" \"c\" \"d\"]" (partition 4 6 ["a" "b" "c" "d"] from0->19))

;; a step smaller than the partition-size results in reuse.
(let [my-vector [:a :b :c :d :e :f]
      my-partition (partition 3 1 my-vector)]
  (println my-vector)
  (println "3 1" my-partition))