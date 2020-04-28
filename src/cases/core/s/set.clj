(ns cases.core.s.set)

;; Returns a set of the distinct elements of coll

;; returns distinct elements
(prn (set '(1 1 2 3 2 4 5 5)))
(prn (set [1 1 2 3 2 4 5 5]))
(prn (set [1 2 3 4 5]))
(prn (set "abcd"))
(prn (set '("a" "b" "c" "d")))
(prn (set {:one 1 :two 2 :three 3}))
(prn (set nil))

(println (set [1 2 3 2 1 2 3]))
(println #{:a :b :c :d})
(println "hash-set" (hash-set :a :b :c :d))
(println "sorted-set" (sorted-set :a :b :c :d))
;------------------------------------------------
(def s #{:a :b :c :d})
(println (conj s :e))
(println (count s))
(println (seq s))
(println (= (conj s :e) #{:a :b :c :d :e}))
(println (s :b))
(println (s :k))