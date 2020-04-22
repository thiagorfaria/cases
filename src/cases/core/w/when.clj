(ns cases.core.w.when)

;; Evaluates test. If logical true, evaluates body in an implicit do.
(println (when (= 1 1) true))
(println (when (not= 1 1) true))

;; Execute command+shift+p to execute on repl
(macroexpand '(when 1 2 3 4))