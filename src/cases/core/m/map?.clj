(ns cases.core.m.map?)

;; Return true if x implements IPersistentMap
(println "(map? {:a 1 :b 2 :c 3})" (map? {:a 1 :b 2 :c 3}))
(println "(map? (hash-map :a 1 :b 2))" (map? (hash-map :a 1 :b 2)))
(println "(map? (sorted-map :a 1 :b 2))" (map? (sorted-map :a 1 :b 2)))
(println "(map? (array-map :a 1 :b 2))" (map? (array-map :a 1 :b 2)))
(println "(map? '(1 2 3))" (map? '(1 2 3)))
(println "(map? #{:a :b :c})" (map? #{:a :b :c}))
(println (type #{:a :b :c}))