(ns cases.core.p.println)

;; Same as print followed by (newline)

(println "Hello world.")

(def items ["hello" :a 1 (list :b 2) \c {:d 4} #{5 6 7}])
(println items)
(prn items)
(println (pr-str items))
(println)
(newline)