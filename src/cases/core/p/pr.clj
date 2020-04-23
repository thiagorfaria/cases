(ns cases.core.p.pr)

;; Prints the object(s) to the output stream that is the current value
;; of *out*.  Prints the object(s), separated by spaces if there is
;; more than one.  By default, pr and prn print in a way that objects
;; can be read by the reader
(pr "foo")
(prn)
(pr {:foo "hello" :bar 34.5})
(prn)
(pr ['a :b "\n" \space "c"])
(prn)
(print ['a :b "\n" \space "c"])
(prn)
