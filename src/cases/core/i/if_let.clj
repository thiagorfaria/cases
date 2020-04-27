(ns cases.core.i.if-let)

;; bindings => binding-form test
;;
;; If test is true, evaluates then with binding-form bound to the value of
;; test, if not, yields else

;; TODO implement more examples
(defn sum-even-numbers [nums]
  (if-let [nums (seq (filter even? nums))]
    (reduce + nums)
    "No even numbers found."))

(println (sum-even-numbers [1 3 5 7 9]))
(println (sum-even-numbers [2 4 6 8]))

(defn if-let-demo [arg]
  (if-let [x arg] "then" "else"))

(println (if-let-demo 1))
(println (if-let-demo nil))
(println (if-let-demo false))

(def x {:whatever 1})
(println (if-let [value (:whatever x)] value "Not found"))
(println (if-let [value (:no-match x)] value "Not found"))