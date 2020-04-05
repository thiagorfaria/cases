(ns cases.c.conj)

;; conj[oin]. Returns a new collection with the xs
;; 'added'. (conj nil item) returns (item).  The 'addition' may
;; happen at different 'places' depending on the concrete type.

;; notice that conjoining to a vector is done at the end
(println (conj [1 2 3] 4))

;; notice conjoining to a list is done at the beginning
(println (conj '(1 2 3) 4))
(println (conj ["a" "b" "c"] "d"))

;; conjoining multiple items is done in order
(println (conj [1 2] 3 4))
(println (conj '(1 2) 3 4))
(println (conj [[1 2] [3 4]] [5 6]))
(println (conj {1 2, 3 4} [5 6]))
(println (conj {:firstname "John" :lastname "Doe"} {:age 25 :nationality "Chinese"}))
(println (conj #{1 3 4} 2))
(println (conj #{1 3 4} 2 1 3))

;; conjoin shows similar behaviour to cons
;; The main difference being that conj works on collections
;; but cons works with seqs.
(println (conj ["a" "b" "c"] ["a" "b" "c"]))

;; conjoin nil with x or xs
(println (conj nil 3))
(println (conj nil 3 4))

;; When conjoining into a map, vector pairs may be provided:
(println (conj {:a 1} [:b 2] [:c 3]))

;; Or maps may be provided, with multiple pairings:
(println (conj {:a 1} {:b 2 :c 3} {:d 4 :e 5 :f 6}))

;; implement stack semantics with conj, peek and pop.

;; we start with a list
(def stack-one '(2 1 0))
(println "list peek" (peek stack-one))
(println "list pop" (pop stack-one))
(println "list type pop" (type (pop stack-one)))
;; push = conj
(println "list conj" (conj stack-one 3))
(println "list type conj" (type (conj stack-one 3)))

;; now let us try a vector
(def stack [0 1 2])
(println "vector peek" (peek stack))
(println "vector pop" (pop stack))
(println "vector type pop" (type (pop stack)))
;; push = conj
(println "vector conj" (conj stack 3))
(println "vector type conj" (type (conj stack 3)))

