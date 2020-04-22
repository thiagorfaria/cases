(ns cases.core.c.cond)

;; Takes a set of test/expr pairs. It evaluates each test one at a
;; time.  If a test returns logical true, cond evaluates and returns
;; the value of the corresponding expr and doesn't evaluate any of the
;; other tests or exprs. (cond) returns nil.
;; ©

(defn pos-neg-or-zero
  "Determines whether or not n is positive, negative, or zero"
  [n]
  (cond
    (< n 0) "negative"
    (> n 0) "positive"
    ;; doesn't evaluate any of the other test
    (> n 4) "positive2"
    :else "zero"))

(println (pos-neg-or-zero 5))
(println (pos-neg-or-zero 4))
(println (pos-neg-or-zero -1))
(println (pos-neg-or-zero 0))

(println (let [grade 85]
           (cond
             (>= grade 90) "A"
             (>= grade 80) "B"
             (>= grade 70) "C"
             (>= grade 60) "D"
             :else "F")))