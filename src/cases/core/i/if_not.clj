(ns cases.core.i.if-not)

;; Evaluates test. If logical false, evaluates and returns then expr,
;; otherwise else expr, if supplied, else nil.
(defn has-neg [coll]
  (if-not (empty? coll)
    (or (neg? (first coll)) (recur (rest coll)))))

(prn (has-neg []))
(prn (has-neg [1 2 -3 4]))

(prn (if-not (zero? 0) :then :else))