(ns cases.core.e.every?)

;; Returns true if (pred x) is logical true for every x in coll, else
;; false.

(prn (every? even? '(2 4 6)))
(prn (every? even? '(1 4 7)))
