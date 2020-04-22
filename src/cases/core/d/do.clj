(ns cases.core.d.do)

;; Evaluates the expressions in order and returns the value of the last. If no
;; expressions are supplied, returns nil. See http://clojure.org/special_forms
;; for more information.
(println (do
           (println "LOG: Computing...")
           (+ 1 1)))

(println (do))

(println ((fn []
            (println "Something")
            (str "Return this"))))
(defn do-example []
  (println "Something")
  "Return this")
(println (do-example))
(println (let [name "John"]
           (println "Something")
           (str "Hello " name)))

(println (if (> 2 1)
           (do
             (println "2 greater than 1")
             true)))

(do (time (range 1000)) nil)