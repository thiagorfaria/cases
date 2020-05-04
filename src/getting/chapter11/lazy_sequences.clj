(ns getting.chapter11.lazy-sequences)

;; ## Sequences without end
(println "## Sequences without end")

(def jack "All work and no play makes Jack a dull boy.")
(def repeated-text (repeat jack))
(map prn (take 20 repeated-text))

;; ## More interesting laziness
(println)
(println "## More interesting laziness")

(prn (take 7 (cycle [1 2 3])))

(def numbers (iterate inc 1))
(println (first numbers))
(println (take 10 numbers))
(println (nth numbers 9))
(println (nth numbers 99))
(println (nth numbers 100))

;; ## Lazy friends
(println)
(println "## Lazy friends")
(def many-nums (take 1000000000 (iterate inc 1)))
(println (take 10 many-nums))

(def evens (map (partial * 2) (iterate inc 1)))
(println (take 20 evens))
(prn (take 10 (interleave numbers (repeat "0"))))
(println (take 10 (interleave numbers evens)))

;; ## Laziness in practice
(println)
(println "## Laziness in practice")

(def numbers (iterate inc 1))
(def titles (map (partial str "Wheel of Time Book ") numbers))
(prn (take 3 titles))

(def first-names ["Bob" "Jane" "Chuck" "Leo"])
(prn first-names)

(def last-names ["Jordan" "Austen" "Dickens" "Tolstoy" "Poe"])
(prn last-names)

(defn combine-names [first-name last-name] (str first-name " " last-name))
(def authors (map combine-names (cycle first-names) (cycle last-names)))
(defn make-book [title author] {:author author :title title})

(def test-book (map make-book titles authors))

(map prn (take 10 test-book))

;; (defn make-title [id title] {:id id :title title})
;; (def test-book2 (map make-title (iterate inc 1) titles))
;; (map prn (take 5 test-book2))

;; ## Behind the scenes
(println)
(println "## Behind the scenes")
(println (lazy-seq [1 2 3]))
(defn chatty-vector [] (print "Here we go!") [1 2 3])
(def s (lazy-seq (chatty-vector)))
(prn (first s))

(defn my-repeat [x] (cons x (lazy-seq (my-repeat x))))
(prn (take 4 (my-repeat "1")))

(defn my-iterate [f x]
  (cons x (lazy-seq (my-iterate f (f x)))))
(println (take 10 (my-iterate (partial + 1) 1)))

(defn my-map [f col]
  (when-not (empty? col)
    (cons (f (first col))
          (lazy-seq (my-map f (rest col))))))

(my-map prn '(1 2 3 4 5))

(println (take 5 (slurp "/Users/thiagofaria/Work/workspace/cases/resources/authors.txt")))
(spit "/Users/thiagofaria/Work/workspace/cases/resources/chap1.txt" "1")

;(def chapters (take 1 (map slurp (map #("/Users/thiagofaria/Work/workspace/cases/resources/chap" % ".txt") numbers))))
;(doall chapters)
;(doseq [c chapters]
;  (println "The chapter text is" c))
;