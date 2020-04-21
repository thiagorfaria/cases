(ns cases.core.o.or)

;; Evaluates exprs one at a time, from left to right. If a form
;; returns a logical true value, or returns that value and doesn't
;; evaluate any of the other expressions, otherwise it returns the
;; value of the last expression. (or) returns nil.
(println "(or true false false)" (or true false false))
(println "(or true true true)" (or true true true))
(println "(or false false false)" (or false false false))
(println "(or nil nil)" (or nil nil))
(println "(or false nil)" (or false nil))
(println "(or true nil)" (or true nil))
(println "(or true (println \"foo\"))" (or true (println "foo")))
(println "(or (println \"foo\") true)" (or (println "foo") true))
(println "(or false 42)" (or false 42))
(println "(or false 42 9999)" (or false 42 9999))
(println "(or 42 9999)" (or 42 9999))
(println "(or nil false)" (or nil false))
(println "(or false nil)" (or false nil))