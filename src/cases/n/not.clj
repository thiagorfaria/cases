(ns cases.n.not)

;; Returns true if x is logical false, false otherwise.

(println "(not true) => " (not true))
(println "(not false) => " (not false))
(println "(not nil) => " (not nil))
 ;; acts as complement of `boolean`
(println "(boolean \"a string\")) => " (boolean "a string"))
(println "(not \"a string\") => " (not "a string"))
(println "(boolean 1) => " (boolean 1))
(println "(not 1) => " (not 1))
(println "(not 0) => " (not 0))
