(ns cases.core.r.re-seq)

;; Returns a lazy sequence of successive matches of pattern in string,
;; using java.util.regex.Matcher.find(), each such match processed with
;; re-groups.

(prn (re-seq #"\d" "clojure 1.1.0"))
(prn (re-seq #"\w+" "mary had a little lamb"))

(def line " RX pkts:18 err:5 drop:48")
(println line)

(prn (re-seq #"(\S+):(\d+)" line))

(prn (re-seq #"[A-Z][a-z]+|[0-9]+" "ManishKumar12332"))