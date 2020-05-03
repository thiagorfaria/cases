(ns cases.core.r.re-matches)

;; Returns the match, if any, of string to pattern, using
;; java.util.regex.Matcher.matches().  Uses re-groups to return the
;; groups.

(prn (re-matches #"hello" "hello, world"))
(prn (re-matches #"hello.*" "hello, world"))
(prn (re-matches #"hello, (.*)" "hello, world"))

(prn (re-matches #"hello" "HELLO"))                         ; case-sensitive
(prn (re-matches #"(?i)hello" "hello"))                     ; case-insensitive
(prn (re-matches #"(?i)hello" "HELLO"))                     ; case-insensitive
(prn (re-matches #"(?i)HELLO" "heLLo"))                     ; case-insensitive