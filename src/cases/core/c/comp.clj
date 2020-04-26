(ns cases.core.c.comp)

;; Takes a set of functions and returns a fn that is the composition
;; of those fns.  The returned fn takes a variable number of args,
;; applies the rightmost of fns to the args, the next
;; fn (right-to-left) to the result, etc.

(def negative-quotient (comp - /))
(println (negative-quotient 8 3))
(println (negative-quotient 8 4))

(def concat-and-reverse (comp (partial apply str) reverse str))
(println (concat-and-reverse "hello " "clojuredocs"))

(defn concat-and-reverse2 [& text]
  (->> text (map str) reverse (apply str)))
(println (concat-and-reverse2 "hello" " " "clojuredocs"))

(println (apply str (reverse (str "hello " "clojuredocs"))))
(println (reverse (str "hello " "clojuredocs")))
(println (apply str (reverse "clojuredocs")))

(println ((comp str +) 8 8 8))

(println (map (comp - (partial + 3) (partial * 2)) [1 2 3 4]))
(println (map #(-> % (* 2) (+ 3) -) [1 2 3 4]))