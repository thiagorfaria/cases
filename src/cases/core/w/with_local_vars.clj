(ns cases.core.w.with-local-vars)

;; varbinding=> symbol init-expr
;;
;; Executes the exprs in a context in which the symbols are bound to
;; vars with per-thread bindings to the init-exprs.  The symbols refer
;; to the var objects themselves, and must be accessed with var-get and
;; var-set

(with-local-vars [a-local-var-variable "value"]
  ;; If you use the symbol by itself, you get the Var back
  (println a-local-var-variable)
  ;; So when using local var variables, you must explicitly
  ;; get the value inside the Var
  (println (var-get a-local-var-variable))
  ;; You can also get the value of a Var by using deref
  (println (deref a-local-var-variable))
  ;; Or the @ reader macro
  (println @a-local-var-variable))