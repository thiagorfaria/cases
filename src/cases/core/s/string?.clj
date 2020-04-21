(ns cases.core.s.string?)

;; Return true if x is a String
(println "(string? \"abc\")" (string? "abc"))
(println "(string? \"\")" (string? ""))
;(println "(string? \a)" (string? \a))
(println "(string? 1)" (string? 1))
(println "(string? [\"a\" \"b\" \"c\"])" (string? ["a" "b" "c"]))
(println "(string? nil)" (string? nil))