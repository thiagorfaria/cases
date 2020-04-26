(ns cases.core.l.loop)

;; Evaluates the exprs in a lexical context in which the symbols in
;; the binding-forms are bound to their respective init-exprs or parts
;; therein. Acts as a recur target.
(defn my-re-seq [re string]
  "Something like re-seq"
  (let [matcher (re-matcher re string)]
    (loop [match (re-find matcher)
           result []]
      (if-not match
        result
        (recur (re-find matcher) (conj result match))))))

(prn (my-re-seq #"\d" "0123456789"))

(loop [x 10]
  (when (> x 1)
    (prn x)
    (recur (- x 2))))