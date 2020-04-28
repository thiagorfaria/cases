(ns cases.core.b.binding)

;; binding => var-symbol init-expr
;;
;; Creates new bindings for the (already-existing) vars, with the
;; supplied initial values, executes the exprs in an implicit do, then
;; re-establishes the bindings that existed before.  The new bindings
;; are made in parallel (unlike let); all init-exprs are evaluated
;; before the vars are bound to their new values.

(def ^:dynamic x 1)
(def ^:dynamic y 1)
(println (+ x y))

(println (binding [x 2 y 3] (+ x y)))

(println (+ x y))

(println)
(println "Speed test. recur is the preferred way.")
(def a (atom 0))
(def ^:dynamic b)
(def d)
(time (loop [r 0] (when (< r 10000000) (recur (inc r)))))
(time (dotimes [_ 10000000] (reset! a 1)))
(time (binding [b 0] (dotimes [_ 10000000] (set! b 1))))
(time (with-local-vars [w 0] (dotimes [_ 10000000] (var-set w 1))))
(time (dotimes [_ 10000000] (def d 1)))

(println)
(def ^:dynamic x 0)
(defn foo [] (println x))
(binding [x 1] (foo))

