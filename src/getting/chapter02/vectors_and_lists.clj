(ns getting.chapter02.vectors_and_lists)

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
(println)
(println "List")
(println (pr-str '(1 2 3 "four" 5 "six")))
(println (pr-str '(1 2.0 2.9999 ​ "four" ​ 5.001 ​ "six")))
(println (pr-str '([1 2 (​ "a" ​ ​ "list" ​ ​ "inside a" ​ ​ "vector" ​)] ​ "inside" ​ ​ "a" ​ ​ "list")))
(println (pr-str (list 1 2 3 "four" 5 "six")))
(def poems '("Iliad" "Odyssey" "Now we are Six"))
(println (count poems))
(println (first poems))
(println (rest poems))
(println (nth poems 2))

;; Lists versus Vectors
(println)
(println "Lists versus Vectors")
(def poems '("Iliad" "Odyssey" "Now We Are Six"))
(println "conj list =>" (pr-str (conj poems "Jabberwocky")))
(def poems-vector ["Iliad" "Odyssey" "Now We Are Six"])
(println "cont vector =>" (pr-str (conj poems-vector "Jabberwocky")))

;; Staying out of trouble
(println)
(println "Staying out of trouble")
(def novels ["Emma" "Comma" "War and Peace"])
(println (pr-str (conj novels "Jaws")))
(def more-novels (conj novels "Jaws"))
(println (pr-str more-novels))
(def novels-list ["Emma" "Comma" "War and Peace"])

;; In the Wild
(println)
(println "In the Wild")

(defn replace-all [string coll]
  (let [matchers (first coll)
        from (first matchers)
        to (last matchers)
        len (count coll)
        text (clojure.string/replace string from to)]
    (if (= 1 len) text (recur text (rest coll)))))

(defn escape-html [string]
  (replace-all string [["&" "&amp"]
                       ["\"" "&quot;"]
                       ["<" "&lt;"]
                       [">" "&gt;"]]))

(println (escape-html "John & Mary \" Mary > John \" John < Mary"))