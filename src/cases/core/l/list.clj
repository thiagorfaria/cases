(ns cases.core.l.list)

;; Creates a new list containing the items.
(prn (list 'a 'b 'c 'd 'e 'f 'g))
(prn (list 1 2 3 4 5))
;; When using list the arguments are evaluated
(prn (let [x 1 y 2] (list x y)))
;; ... and when using quote ' they are not:
(prn (let [x 1 y 2] '(x y)))
;; .. neither if you use ~
(prn (let [x 1 y 2] '(~x ~y)))
;; there is syntax quote ` (back tick) that allows selective evaluation inside it with ~:
(println (let [x 1 y 2] `(~x ~y)))