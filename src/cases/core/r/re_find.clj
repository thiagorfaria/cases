(ns cases.core.r.re-find)

;; Returns the next regex match, if any, of string to pattern, using
;; java.util.regex.Matcher.find().  Uses re-groups to return the
;; groups.

(def matcher (re-matcher #"\d+" "abc12345def"))
(prn (re-find matcher))

(re-find #"\d+" "abc12345def")

(def phone-number "672-345-456-3212")
(def matcher (re-matcher #"\d+" phone-number))
(prn (re-find matcher))
(prn (re-find matcher))
(prn (re-find matcher))
(prn (re-find matcher))
(prn (re-find matcher))

(def line " RX packets:1871074138 errors:5 dropped:48 overruns:9")
(prn line)
(prn (re-find #"(\S+):(\d+)" line))
(prn (re-find #"(\S+:(\d+)) \S+:\d+" line))
(prn (re-find #"(\D+)|(\d+)" "word then number 57"))
(prn (re-find #"(\D+)|(\d+)" "57 number then word"))
(prn (re-find #"(\d*)(\S)\S+" "lots o' digits 123456789"))
(prn (re-find #"(?:\S+):(\d+)" line))
(prn (re-find #"(\d\d\d) (USD)" "450 USD"))
(def testcase "Line 1\nLine 2\nTarget Line\nLine 4\nNot a target line")
(prn (re-find #"(?im)^target.*$" testcase))