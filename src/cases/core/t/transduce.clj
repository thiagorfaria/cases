(ns cases.core.t.transduce)

;; reduce with a transformation of f (xf). If init is not
;; supplied, (f) will be called to produce it. f should be a reducing
;; step function that accepts both 1 and 2 arguments, if it accepts
;; only 2 you can add the arity-1 with 'completing'. Returns the result
;; of applying (the transformed) xf to init and the first item in coll,
;; then applying xf to that result and the 2nd item, etc. If coll
;; contains no items, returns init and f is not called. Note that
;; certain transforms may inject or skip items.
;; TODO try to understand other time.
(def xf (comp (filter odd?) (take 10)))
(println xf)
(println (transduce xf conj (range)))
(println (transduce xf + (range)))
(println (transduce xf + 17 (range)))
(println (transduce xf str (range)))
(println (transduce xf str "..." (range)))