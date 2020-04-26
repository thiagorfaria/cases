(ns cases.core.c.complement)

;; Takes a fn f and returns a fn that takes the same arguments as f,
;; has the same effects, if any, and returns the opposite truth value.

(def not-empty? (complement empty?))
(println (not-empty? []))
(println (not-empty? [1 2]))

(defn contains-char? [the-string, the-char]
  (some #(= the-char %) the-string))

(println (contains-char? "text" \t))
(println (contains-char? "text" \a))

(def does-not-contain-char? (complement contains-char?))
(println (does-not-contain-char? "text" \t))
(println (does-not-contain-char? "text" \a))

(println "not even 1 2 3 4" (map (complement even?) '(1 2 3 4)))
(println "even 1 2 3 4" (map even? '(1 2 3 4)))
(println "not even 1 2 3 4" (map #(not (even? %)) '(1 2 3 4)))

