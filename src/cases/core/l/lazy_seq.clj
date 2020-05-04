(ns cases.core.l.lazy-seq)

;; Takes a body of expressions that returns an ISeq or nil, and yields
;; a Seqable object that will invoke the body only the first time seq
;; is called, and will cache the result and return it on all subsequent
;; seq calls. See also - realized?

(defn positive-numbers
  ([] (positive-numbers 1))
  ([n] (lazy-seq (cons n (positive-numbers (inc n))))))

(println (take 5 (positive-numbers)))
(println (take 5 (positive-numbers 6)))


(defn fib
  ([] (fib 0 1))
  ([a b] (lazy-seq (cons a (fib b (+ a b))))))

(println (take 10 (fib)))
(println (take 10 (fib)))
(println (take 10 (fib 2 3)))