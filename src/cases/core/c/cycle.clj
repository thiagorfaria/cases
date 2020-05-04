(ns cases.core.c.cycle)

;; Returns a lazy (infinite!) sequence of repetitions of the items in coll.

(prn (take 5 (cycle ["a" "b"])))
(prn (take 10 (cycle (range 0 3))))

;; Typically map works through its set of collections
;; until any one of the collections is consumed.
;; 'cycle' can be used to repeat the shorter collections
;; until the longest collection is consumed.
(println (mapv #(vector %2 %1) (cycle [1 2 3 4]) [:a :b :c :d :e :f :g :h :i :j :k :l]))