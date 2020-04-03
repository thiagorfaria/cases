(ns cases.s.str)

;; With no args, returns the empty string. With one arg x, returns
;; x.toString().  (str nil) returns the empty string. With more than
;; one arg, returns the concatenation of the str values of the args.

"some string"
"some string"

(println (str))
(println (str nil))
(println (str 1))
(println (str 1 2 3))
(println (str 1 'symbol :keyword))

;; A very common usage of str is to apply it to an existing collection:
(println (apply str [1 2 3]))
"123"

;; compare it with:
(println (str [1 2 3]))
"[1 2 3]"

;; sometimes when printing lazy sequences you do not get what you want.
(println (str (take 5 (range 10))))

;; in those cases `pr-str` to the rescue.
(println (pr-str (take 5 (range 10))))