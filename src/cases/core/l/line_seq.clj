(ns cases.core.l.line-seq
  (:require [clojure.java.io :as io])
  (:import (java.io BufferedReader StringReader)))

;; Returns the lines of text from rdr as a lazy sequence of strings.
;; rdr must implement java.io.BufferedReader.

(with-open [rdr (io/reader "/Users/thiagofaria/Work/workspace/cases/resources/authors.txt")]
  (println (count (line-seq rdr))))

(prn (line-seq (BufferedReader. (StringReader. "1\n2\n\n3"))))