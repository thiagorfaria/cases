(ns cases.core.p.pr-str)

;; pr to a string, returning it
(def x [1 2 3 4 5])

;; Turn that data into a string...
(println (pr-str x))

;; ...and turn that string back into data!
(println (read-string (pr-str x)))

;; you can think of pr-str as the inverse of read-string
;; turn string into symbols
(println (read-string "(a b foo :bar)"))

(println (pr-str "(a b foo :bar)"))