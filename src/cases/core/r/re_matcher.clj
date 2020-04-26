(ns cases.core.r.re-matcher)

;; Returns an instance of java.util.regex.Matcher, for use, e.g. in
;; re-find.

(prn (re-matcher #"\d+" "abc12345def"))
(prn (type (re-matcher #"\d+" "abc12345def")))
(def matcher (re-matcher #"\d+" "abc12345def"))
(prn (re-find matcher))