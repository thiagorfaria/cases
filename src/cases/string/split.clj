(ns cases.string.split
  (:use [clojure.string :only (split)]))

;; Splits string on a regular expression.  Optional argument limit is
;; the maximum number of splits. Not lazy. Returns vector of the splits.

(prn (split "Clojure is awesome!" #"(?:\s)"))
(prn (split "q1w2e3r4t5y6u7i8o9p0" #"\d+"))
(prn (split "q1w2e3r4t5y6u7i8o9p0" #"\d+" 5))
(prn (split " q1w2 " #""))
(prn (split " something and ACamelName " #"(?=[A-Z])"))