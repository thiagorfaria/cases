(ns cases.core.t.try)

;; The exprs are evaluated and, if no exceptions occur, the value of the last
;; is returned. If an exception occurs and catch clauses are provided, each is
;; examined in turn and the first for which the thrown exception is an instance
;; of the named class is considered a matching catch clause. If there is a
;; matching catch clause, its exprs are evaluated in a context in which name is
;; bound to the thrown exception, and the value of the last is the return value
;; of the function. If there is no matching catch clause, the exception
;; propagates out of the function. Before returning, normally or abnormally,
;; any finally exprs will be evaluated for their side effects. See
;; http://clojure.org/special_forms for more information.
(try
  (/ 1 0)
  (catch Exception e (prn (str "caught exception: " (.getMessage e))))
  (finally (prn "Release some resource")))
