(ns cases.string.join
  (:use [clojure.string]))

;; Returns a string of all elements in coll, as returned by (seq coll),
;; separated by an optional separator.

(prn (join ", " [1 2 3]))

(println (join "\n" (split "The Quick Brown Fox" #"\s")))

(let [my-vector ["spam" nil "eggs" "" "spam"]
      remove-blank (remove blank? my-vector)]
  (-> ", " (join remove-blank) prn))

(prn (join [1 2 3]))