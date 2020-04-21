(ns cases.core.a.and)

;; Evaluates exprs one at a time, from left to right. If a form
;; returns logical false (nil or false), and returns that value and
;; doesn't evaluate any of the other expressions, otherwise it returns
;; the value of the last expr. (and) returns true.
(println "(and true true)" (and true true))
(println "(and true false)" (and true false))
(println "(and false false)" (and false false))
(println "(and '() '())" (and '() '()))
(println "(and '[] '[])" (and '[] '[]))
(println "(and 0 1)" (and 0 1))
(println "(and 1 0)" (and 1 0))
(println "(and false nil)" (and false nil))
(println "(and nil false)" (and nil false))
(println "(and false (println \"foo\"))" (and false (println "foo")))
(println "(and (println \"foo\") false)" (and (println "foo") false))
(println "(and nil nil)" (and nil nil))