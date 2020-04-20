(ns cases.core.c.count)

;; Returns the number of items in the collection. (count nil) returns
;; 0.  Also works on strings, arrays, and Java Collections and Maps

(println "count nil =>" (count nil))
(println "count [] =>" (count []))
(println "count [1 2 3] =>" (count [1 2 3]))
(println "count {:one 1 :two 2} =>" (count {:one 1 :two 2}))
(println "count [1 \\a \"string\" [1 2] {:foo :bar}] =>" (count [1 \a "string" [1 2] {:foo :bar}]))
(println "count \"string\" =>" (count "string"))
(println (Integer/MAX_VALUE))
