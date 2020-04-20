(ns cases.core.l.let)

;; binding => binding-form init-expr
;; Evaluates the exprs in a lexical context in which the symbols in
;; the binding-forms are bound to their respective init-exprs or parts
;; therein.

;; let is a Clojure special form, a fundamental building block of the language.
;;
;; In addition to parameters passed to functions, let provides a way to create
;; lexical bindings of data structures to symbols. The binding, and therefore
;; the ability to resolve the binding, is available only within the lexical
;; context of the let.
;;
;; let uses pairs in a vector for each binding you'd like to make and the value
;; of the let is the value of the last expression to be evaluated. let also
;; allows for destructuring which is a way to bind symbols to only part of a
;; collection.

;; A basic use for a let:
(println (let [x 1] x))

;; Note that the binding for the symbol y won't exist outside of the let:
(println (let [y 1] y))
;(prn y)

;; Note that if you use def inside a let block, your interned variable is within
;; the current namespace and will appear OUTSIDE of the let block.
(println (let [y 1] (def z y) y))

;; Another valid use of let:
(println (let [a 1 b 2] (+ a b)))

;; The forms in the vector can be more complex (this example also uses
;; the thread macro):
(println (let [c (+ 1 2) [d e] [5 6]] (-> (+ d e) (- c))))

;; The bindings for let need not match up (note the result is a numeric
;; type called a ratio):
(println (let [[g h] [1 2 3]] (/ g h)))

;; From http://clojure-examples.appspot.com/clojure.core/let with permission.