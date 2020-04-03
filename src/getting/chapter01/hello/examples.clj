(ns getting.chapter01.hello.examples)

;; Do two semicolons add up to a whole colon?
(println "Hello, world!")

;; str
(println "(str \"Clo\" \"jure\") =>" (str "Clo" "jure"))
(println "(str \"Hello,\" \" \" \"world\" \"!\") =>" (str "Hello," " " "world" "!"))
(println "(str 3 \" \" 2 \" \" 1 \" Blast off!\") =>" (str 3 " " 2 " " 1 " Blast off!"))

;; count
(println "(count \"Hello, world!\") =>" (count "Hello, world!"))
(println "(count \"Hello\") =>" (count "Hello"))
(println "(count \"\") =>" (count ""))

;; Boolean
(println true false)

;; nil
(println "Nobody's home:" nil)
(println "We can print many things:" true false nil)


;; Arithmetic
(println "\nArithmetic")
(println "(+ 1900 84) =>" (+ 1900 84))
(println "(* 16 124) =>" (* 16 124))
(println "(- 2000 16) =>" (- 2000 16))
(println "(/ 25792 13) =>" (/ 25792 13))
;; average between 1984 and 2010
(println "(/ (+ 1984 2010) 2) =>" (/ (+ 1984 2010) 2))
(println "(+ 1000 500 500 1) =>" (+ 1000 500 500 1))
(println "(- 2000 10 4 2) =>" (- 2000 10 4 2))
(println "(/ 8 3) =>" (/ 8 3))
(println "(quot 8 3) =>" (quot 8 3))
(println "(/ (+ 1984.0 2010.0) 2) =>" (/ (+ 1984.0 2010.0) 2))
(println "(+ 1984 2010.0) =>" (+ 1984 2010.0))

;; No Variable Assignment, but close
(println "\nNo Variable Assignment, but close")
(def first-name "Russ")
(println "first-name =>" first-name)
(def the-average (/ (+ 20 40.0) 2.0))
(println "the-average =>" the-average)

;; A function of your own
(println "\nA function of your own")
(defn hello-world []
  (println "(hello-word) =>" "Hello, world!"))
(hello-world)
(defn say-welcome [what]
  (println "(say-welcome \"Clojure\") =>" "Welcome to" what))
(say-welcome "Clojure")
(defn average [a b]
  (/ (+ a b) 2.0))
(println "(average 5.0 10.0) =>" (average 5.0 10.0))
(defn chatty-average [a b]
  (println "chatty-average function called")
  (println "** first-argument:" a)
  (println "** second argument:" b)
  (/ (+ a b) 2.0))
(println (chatty-average 10 20))