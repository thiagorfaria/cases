(ns cases.core.i.if)

;; Evaluates test.
(defn is-small? [number]
  (if (< number 100) "yes" "no"))

(println (is-small? 50))
(println (is-small? 500))

(println "1" (if nil "logical true" "logical false"))
(println "2" (if false "logical true" "logical false"))
(println "3" (if Boolean/FALSE "logical true" "logical false"))
(println "4" (if 0 "logical true" "logical false"))
(println "5" (if [nil] "logical true" "logical false"))
(println "6" (if (first [nil]) "logical true" "logical false"))
(println "7" (if (Boolean. false) "logical true" "logical false"))
(println "8" (if (boolean (Boolean. false)) "logical true" "logical false"))
(println "9" (if (Boolean/valueOf (Boolean. false)) "logical true" "logical false"))