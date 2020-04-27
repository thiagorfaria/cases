(ns cases.core.w.when)

;; Evaluates test. If logical true, evaluates body in an implicit do.
(println (when (= 1 1) true))
(println (when (not= 1 1) true))

;; Execute command+shift+p to execute on repl
(macroexpand '(when 1 2 3 4))

;; if + do
(println "when"
         (when (= 1 1)
           (println "when 1")
           (println "when 2")
           (println "when 3")
           (println "when 4")
           5))

(println)
(println "if+do"
         (if (= 1 1)
           (do (println "if+do 1")
               (println "if+do 2")
               (println "if+do 3")
               (println "if+do 4")
               5)))