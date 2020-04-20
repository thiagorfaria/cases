(ns cases.core.r.read-string)

;; Reads one object from the string s. Optionally include reader
;; options, as specified in read.

;; Note that read-string can execute code (controlled by *read-eval*),
;; and as such should be used only with trusted sources.

;; For data structure interop use clojure.edn/read-string

(println "1.1 =>" (read-string "1.1"))
(println "(+ 1 1) =>" (read-string "(+ 1 1)"))
(println "(+ 1 1) =>" (eval (read-string "(+ 1 1)")))
(println "(prn-str (+ 1 1)) =>" (read-string (prn-str (+ 1 1))))
(println "23 =>" (+ 11 (read-string "23")))
(println "; foo\n5 =>" (read-string "; foo\n5"))
(println "#^String x =>" (read-string "#^String x"))
(println "(1) =>" (read-string "(1)"))
(println "(+ 1 2) (- 3 2) =>" (read-string "(+ 1 2) (- 3 2)"))
(println "@a =>" (read-string "@a"))
(println "(+ 1 2)))))) =>" (read-string "(+ 1 2))))))"))
(println "::whatever-namespace-you-are-in =>" (read-string "::whatever-namespace-you-are-in"))

