(ns cases.core.w.when-let)

;; bindings => binding-form test
;;
;; When test is true, evaluates body with binding-form bound to the value of test
(defn drop-one
  [coll]
  (when-let [s (seq coll)]
    (rest s)))

(println (drop-one [1 2 3]))
(println (drop-one []))

(def x {:whatever 1})

(when-let [value (:whatever x)]
  (println "x+1 =" (inc value)))
