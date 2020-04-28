(ns cases.core.r.repeat)

;; Returns a lazy (infinite!, or length n if supplied) sequence of xs.

(println (take 5 (repeat "x")))

(println (repeat 5 "x"))

;; TODO see again
(defn tally [n]
  (apply str
         (concat
           (repeat (quot n 5) "卌")
           (repeat (mod n 5) "|"))))

(println (map tally (range 1 11)))