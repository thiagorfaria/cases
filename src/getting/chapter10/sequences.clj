(ns getting.chapter10.sequences
  (:require [clojure.java.io :as io]))


;; ## One thing after another
(println "##One thing after another")

(defn flavor [x]
  (cond
    (list? x) :list
    (vector? x) :vector
    (set? x) :set
    (map? x) :map
    (string? x) :string
    :else :unknown))

(defn list-specific-count [x] (println (count x)))
(defn vector-specific-count [x] (println (count x)))
(defn set-specific-count [x] (println (count x)))
(defn map-specific-count [x] (println (count x)))
(defn string-specific-count [x] (println (count x)))

(defmulti my-count flavor)
(defmethod my-count :list [x] (list-specific-count x))
(defmethod my-count :vector [x] (vector-specific-count x))
(defmethod my-count :set [x] (set-specific-count x))
(defmethod my-count :map [x] (map-specific-count x))
(defmethod my-count :string [x] (string-specific-count x))

(def title-seq (seq ["Emma" "Oliver Twist" "Robinson Crusoe"]))
(prn title-seq)
(def title-seq2 (seq '("Emma" "Oliver Twist" "Robinson Crusoe")))
(prn title-seq2)

(prn (seq {:title "Emma" :author "Austen" :published 1815}))
(prn (seq (seq ["Emma" "Oliver Twist" "Robinson Crusoe"])))

(prn [] '() {})

;; ## A Universal Interface
(println)
(println "## A Universal Interface")

(prn (first title-seq))
(prn (rest title-seq))
(prn (cons "Emma" (seq (list "Oliver Twist" "Robinson Crusoe"))))

(defn my-count [col]
  (let [the-seq (seq col)]
    (loop [n 0 s the-seq]
      (if (seq s)
        (recur (inc n) (rest s))
        n))))

(println (my-count []))
(println (my-count [1]))
(println (my-count [1 2]))
(println (my-count [0 1 2 3 4 5 6 7 8 9]))

;; ## A rich toolkit
(println)
(println "## A rich toolkit")
(def title ["Jaws" "Emma" "2001" "Dracula"])
(prn title)
(prn (sort title))
(prn (reverse title))
(prn (reverse (sort title)))

(def title-and-authors ["Jaws" "Benchley" "2001" "Clarke"])
(prn title-and-authors)
(prn (partition 2 title-and-authors))

(def titles ["Jaws" "2001"])
(def authors ["Benchley" "Clarke"])
(prn titles)
(prn authors)
(prn (interleave titles authors))

(def scary-animal ["Lions" "Tigers" "Bears"])
(prn scary-animal)
(prn (interpose "and" scary-animal))

;; ## Made richer with functional values
(println)
(println "## Made richer with functional values")
(prn (filter neg? '(1 -22 3 -99 4 5 6 -77)))

(def books
  [{:title "Deep Six" :price 13.99 :genre :sci-fi :rating 6}
   {:title "Dracula" :price 1.99 :genre :horror :rating 6}
   {:title "Emma" :price 7.99 :genre :comedy :rating 8}
   {:title "2001" :price 10.59 :genre :sci-fi :rating 5}])

(defn print-books [vec-books]
  (let [b (if vec-books vec-books books)]
    (loop [i 0 book b]
      (when (>= (count book) 1)
        (prn (nth b i))
        (recur (inc i) (rest book)))))
  (println))

(print-books nil)

(defn cheap? [book]
  (when (<= (:price book) 9.99) book))

(map prn (filter cheap? books))

(prn (some cheap? books))
(if (some cheap? books) (println "We have cheap books for sale!"))

;; ## Map
(println)
(println "## Map")
(def some-numbers [1 53 811])
(def doubled (map (fn [n] (* 2 n)) some-numbers))
(println doubled)
(def doubled2 (map #(* 2 %) some-numbers))
(println doubled2)
(prn books)
(prn (map :title books))

(println (map #(count (:title %)) books))
(println (map (comp count :title) books))

(println (for [b books]
           (count (:title b))))

;; ## Reduce
(println)
(println "## Reduce")
(def numbers [10 20 30 40 50])
(println numbers)

(println (apply + numbers))
(defn add2 [a b] (+ a b))
(println (reduce add2 0 numbers))
(println (reduce + numbers))

(defn hi-price [hi book]
  (if (> (:price book) hi)
    (:price book)
    hi))

(map prn [1 2 3 4 5])

(print-books nil)
(println (reduce hi-price 0 books))

;; ## Composing a solution
(println)
(println "## Composing a solution")
(def books-sort-by-rating (take 3 (reverse (sort-by :rating books))))

(println "Top 3 rating books")
(print-books books-sort-by-rating)

(->> books (sort-by :rating) reverse (take 3) (map :title) (interpose " // ") (apply str) prn)

;; ## Other sources of sequences
(println)
(println "## Other sources of sequences")

(defn listed-author? [author]
  (with-open [r (io/reader "/Users/thiagofaria/Work/workspace/cases/resources/authors.txt")]
    (some (partial = author) (line-seq r))))

(println (listed-author? "Paulo Coelho"))
(println (listed-author? "Thiago Faria"))

(def re #"Pride and Prejudice.+")
(def title2 "Pride and Prejudice and Zombies")

(if (re-matches re title2)
  (println "We have a classic!"))

(prn (re-seq #"\w+" title2))