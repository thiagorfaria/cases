(ns cases.core.e.every-pred)

;; Takes a set of predicates and returns a function f that returns true if all of its
;; composing predicates return a logical true value against all of its arguments, else it returns
;; false. Note that f is short-circuiting in that it will stop execution on the first
;; argument that triggers a logical false result against the original predicates.

(println "Is 3 9 11 numbers and odd?" ((every-pred number? odd?) 3 9 11))

(println "1" ((comp (partial > 5) count) "abcdef"))
(println "2" ((every-pred string? (comp (partial > 5) count)) "abc"))
(println "3" ((every-pred string? (comp (partial > 5) count)) "abcdef"))

((comp (partial println "4") (partial > 5) count) "abcdef")
(->> "abcdef" count (> 5) (println "5"))