(ns cases.core.t.ex-times)

;; Evaluates expr and prints the time it took.  Returns the value of
;; expr.
(println (time (Thread/sleep 100)))
(time (doall (println "Testing")))

(with-out-str (time (Thread/sleep 1000)))