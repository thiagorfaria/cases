(ns cases.core.c.conj)

;; conj[oin]. Returns a new collection with the xs
;; 'added'. (conj nil item) returns (item).  The 'addition' may
;; happen at different 'places' depending on the concrete type.

;; notice that conjoining to a vector is done at the end
(prn "conj vector + number =>" (conj [1 2 3] 4))

;; notice conjoining to a list is done at the beginning
(prn "conj list + number =>" (conj '(1 2 3) 4))
(prn "conj vector + number =>" (conj ["a" "b" "c"] "d"))

;; conjoining multiple items is done in order
(prn "conj vector + numbers =>" (conj [1 2] 3 4))
(prn "conj list + numbers =>" (conj '(1 2) 3 4))
(prn "conj vector from vector =>" (conj [[1 2] [3 4]] [5 6]))
(prn "conj map + vector =>" (conj {1 2, 3 4} [5 6]))
(prn "conj map + map =>" (conj {:firstname "John" :lastname "Doe"} {:age 25 :nationality "Chinese"}))
(prn (conj #{1 3 4} 2))
(prn (conj #{1 3 4} 2 1 3))

;; conjoin shows similar behaviour to cons
;; The main difference being that conj works on collections
;; but cons works with seqs.
(prn "conj 2 vectors =>" (conj ["a" "b" "c"] ["a" "b" "c"]))

;; conjoin nil with x or xs
(prn "conj nil + number =>" (conj nil 3))
(prn "conj nil + numbers =>" (conj nil 3 4))

;; When conjoining into a map, vector pairs may be provided:
(prn "conj map + vectors =>" (conj {:a 1} [:b 2] [:c 3]))

;; Or maps may be provided, with multiple pairings:
(prn "conj maps =>" (conj {:a 1} {:b 2 :c 3} {:d 4 :e 5 :f 6}))

;; implement stack semantics with conj, peek and pop.

;; we start with a list
(def stack-one '(2 1 0))
(prn "list peek" (peek stack-one))
(prn "list pop" (pop stack-one))
(prn "list type pop" (type (pop stack-one)))
;; push = conj
(prn "list conj" (conj stack-one 3))
(prn "list type conj" (type (conj stack-one 3)))

;; now let us try a vector
(def stack [0 1 2])
(prn "vector peek" (peek stack))
(prn "vector pop" (pop stack))
(prn "vector type pop" (type (pop stack)))
;; push = conj
(prn "vector conj" (conj stack 3))
(prn "vector type conj" (type (conj stack 3)))

