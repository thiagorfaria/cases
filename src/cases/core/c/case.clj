(ns cases.core.c.case)

;; Takes an expression, and a set of clauses.
;;
;; Each clause can take the form of either:
;;
;; test-constant result-expr
;;
;; (test-constant1 ... test-constantN)  result-expr
;;
;; The test-constants are not evaluated. They must be compile-time
;; literals, and need not be quoted.  If the expression is equal to a
;; test-constant, the corresponding result-expr is returned. A single
;; default expression can follow the clauses, and its value will be
;; returned if no clause matches. If no default expression is provided
;; and no clause matches, an IllegalArgumentException is thrown.
;;
;; Unlike cond and condp, case does a constant-time dispatch, the
;; clauses are not considered sequentially.  All manner of constant
;; expressions are acceptable in case, including numbers, strings,
;; symbols, keywords, and (Clojure) composites thereof. Note that since
;; lists are used to group multiple constants that map to the same
;; expression, a vector can be used to match a list if needed. The
;; test-constants need not be all of the same type.

(println (let [my-str "hello"]
           (case my-str
             "" 0
             "hello" (count my-str))))

;; (let [my-str "no match"]
;;   (case my-str
;;     "" 0
;;     "hello" (count my-str)))
;; No matching clause: no match
;;  [Thrown class java.lang.IllegalArgumentException]

(println (let [my-str "no match"]
           (case my-str
             "" 0
             "hello" (count my-str)
             "default")))
(println (case :y
           (:x :y :z) "x, y, or z"
           "default"))

(println (let [my-seq '(1 2)]
           (case my-seq
             (()) "empty seq"
             ((1 2)) "my seq"
             "default")))

;; weird
(println (let [my-vec [1 2]]
           (case my-vec
             [] "empty vec"
             (vec '(1 2)) "my vec"
             "default")))

;; Good
(println (let [x 10]
           (cond
             (= x 10) :ten
             (= x 20) :twenty
             (= x 30) :thirty
             :else :dunno)))

;; better
(println (let [x 20]
           (condp = x
             10 :ten
             20 :twenty
             30 :thirty
             :dunno)))

;; best
(println (let [x 30]
           (case x
             10 :ten
             20 :twenty
             30 :thirty
             :dunno)))