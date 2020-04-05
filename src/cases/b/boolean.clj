(ns cases.b.boolean)

;; Return true if x is a Boolean
(println "true =>" (boolean? true))
(println "false =>" (boolean? false))
(println "nil =>" (boolean? nil))
(println "[] =>" (boolean? []))
(println "{} =>" (boolean? {}))
(println "'() =>" (boolean? '()))
(println "#{} =>" (boolean? #{}))
(println "\"\" =>" (boolean? ""))
(println "0 =>" (boolean? 0))
(println "1 =>" (boolean? 1))
(println "(new Boolean \"true\") =>" (boolean? (new Boolean "true")))
