(ns cases.core.s.slurp)


;; Opens a reader on f and reads all its contents, returning a string.
;; See clojure.java.io/reader for a complete list of supported arguments.

(prn (take 5 (slurp "http://clojuredocs.org")))