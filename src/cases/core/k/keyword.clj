(ns cases.core.k.keyword)

;; Returns a Keyword with the given namespace and name.  Do not use :
;; in the keyword strings, it will be added automatically.

(prn (keyword 'foo))
(prn (keyword "foo"))
(prn (keyword "user" "foo"))
(prn (keyword (str *ns*) "foo"))