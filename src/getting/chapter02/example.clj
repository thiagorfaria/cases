(ns getting.chapter02.example)

;; A tookit of function
(println "A tookit of function")
(println [1 2 3 4])
(println [0 [1 [true 3 "four" 5] 6] 7])

;; A tookit of function
(println)
(println "A tookit of function")
(println (vector true 3 "four" 5))
(def novels ["Emma" "Coma" "War and Peace"])
(println "count =>" (count novels))
(println "first =>" (first novels))
(println "rest =>" (pr-str (rest novels)))
(println "type =>" (type (rest novels)))

;; Growing your vector
(println)
(println "Growing your vector")
(println (pr-str (conj novels "Carrie")))
(println (type (conj novels "Carrie")))
(println (pr-str (cons "Carrie" novels)))
(println (type (cons "Carrie" novels)))

;; List
