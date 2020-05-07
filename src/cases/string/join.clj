(ns cases.string.join
  (:require [clojure.string :as str]))

;; Returns a string of all elements in coll, as returned by (seq coll),
;; separated by an optional separator.

(prn (str/join ", " [1 2 3]))

(println (str/join "\n" (str/split "The Quick Brown Fox" #"\s")))

(let [my-vector ["spam" nil "eggs" "" "spam"]
      remove-blank (remove str/blank? my-vector)]
  (-> ", " (str/join remove-blank) prn))

(prn (str/join [1 2 3]))