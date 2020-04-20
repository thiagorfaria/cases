(ns cases.core.p.prn-str)

;; pr to a string, returning it
(def x [1 2 3 4 5])

;; Turn that data into a string...
(print (prn-str x))
(print (prn-str "(a b foo :bar)"))

;; ...and turn that string back into data!
(println (read-string (prn-str x)))

;; you can think of pr-str as the inverse of read-string
;; turn string into symbols
(println (read-string "(a b foo :bar)"))

(set! *print-length* 10)
(print (prn-str (range 15)))

(set! *print-length* -1)
(print (prn-str (range 15)))