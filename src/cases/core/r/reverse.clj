(ns cases.core.r.reverse)

;; Returns a seq of the items in coll in reverse order. Not lazy.
(println (reverse '(1 2 3)))
(println (apply str (reverse "clojure")))
(println (reverse "clojure"))