(ns cases.core.c.cond->)

;; Takes an expression and a set of test/form pairs. Threads expr (via ->)
;; through each form for which the corresponding test
;; expression is true. Note that, unlike cond branching, cond-> threading does
;; not short circuit after the first true test expression.

(println (let [value 2]
           (cond-> value
                   true inc
                   false (* 42)
                   ;; Doesn't change the bindings from let
                   (= value 3) (* 10)
                   (= 2 2) (* 3))))


(defn divisible-by? [divisor number]
  (zero? (mod number divisor)))
(defn say [n]
  (cond-> nil
          (divisible-by? 3 n) (str "Fizz")
          (divisible-by? 5 n) (str "Buzz")
          :always             (or (str n))))
(println (say 1))
(println (say 3))
(println (say 5))
(println (say 15))