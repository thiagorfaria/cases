(ns cases.e.eval)


;; Evaluates the form data structure (not text!) and returns the result.

(def ^:dynamic *foo* "(println [1 2 3])")
(println *foo*)

; Notice eval'ing a string does not work.
(println (eval *foo*))

(eval (read-string *foo*))

(println (eval '(let [a 10] (+ 3 4 a))))


(def x '(+ 2 3))
(println x)
(println (eval x))
