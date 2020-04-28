(ns cases.core.a.alter-var-root)

;; Atomically alters the root binding of var v by applying f to its
;; current value plus any args

(defn sqr [n] "Squares a number" (* n n))
(println (sqr 5))

(alter-var-root
  (var sqr)                                                 ; var to alter
  (fn [f]                                                   ; fn to apply to the var's value
    #(do (println "Squaring" %)                             ; returns a new fn wrapping old fn
         (f %))))

(println (sqr 5))

(def string "abcd")
(println string)
(alter-var-root #'string (constantly "wxyz"))
(println string)
(alter-var-root #'string (constantly "1234"))
(println string)


;; TODO see again
(definline times-pi [x] `(* ~x 3.14))
(alter-var-root #'times-pi (fn [_] (constantly 1)))
(println (times-pi 10))
;; Remove the inlining to pass through the var indirection (credits @bronsa)
(alter-meta! #'times-pi dissoc :inline-arities :inline)
(println (times-pi 10))