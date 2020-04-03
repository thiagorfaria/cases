(ns cases.ex-read-string)

;; Reads one object from the string s. Optionally include reader
;; options, as specified in read.

;; Note that read-string can execute code (controlled by *read-eval*),
;; and as such should be used only with trusted sources.

;; For data structure interop use clojure.edn/read-string

(println (read-string "1.1"))
; (println (read-string "1.1.1 (+ 1 1)"))
(println (read-string "(+ 1 1)"))
(println (eval (read-string "(+ 1 1)")))
(println (read-string (prn-str (+ 1 1))))
(println (+ 11 (read-string "23")))
(println (read-string "; foo\n5"))
(println (read-string "#^String x"))
(println (read-string "(1)"))
(println (read-string "(+ 1 2) (- 3 2)"))
(println (read-string "@a"))
(println (read-string "(+ 1 2))))))"))
(println (read-string "::whatever-namespace-you-are-in"))

