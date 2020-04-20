(ns cases.core.r.rest)

;; Returns a possibly empty seq of the items after the first. Calls seq on its
;; argument.

(println (rest [1 2 3 4 5]))
(println (rest ["a" "b" "c" "d" "e"]))
(println (rest '()))
(println (rest nil))

(def year-books ["1491" "April 1965" "1984" "2001"])
(println "nth 2 =>" (nth year-books 2))
(println (year-books 2))