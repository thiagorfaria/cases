(ns getting.chapter05.more_capable_functions)

;; One Function, Different Parameters
(println "One Function, Different Parameters")
(defn greet
  ([to-whom] (println "Welcome" to-whom "to Blotts Books"))
  ([message to-whom] (println message to-whom)))
(greet "Dolly")
(greet "Howdy" "Stranger")
;; The technical term for the number of arguments a function takes is arity
;; multi-arity
(defn greet2
  ([to-whom] (greet2 "Welcome to Blotts Books" to-whom))
  ([message to-whom] (println message to-whom)))
(greet2 "Dolly")
(greet2 "Howdy" "Stranger")

;; Arguments with Wild Abandon
(println)
(println "Arguments with Wild Abandon")
(defn print-any-args [& args]
  (println "My arguments are:" args)
  (println "The first argument is:" (first args)))
(print-any-args 7 true nil)

;; & is called varargs
(println)
(defn new-print-any-args [x & args]
  (println "My ordinary argument before is:" x)
  (println "My arguments are:" args)
  (println "The first argument is:" (first args)))
(new-print-any-args 7 true nil)

;; Multimethods
(defn normalize-book [book]
  (if (vector? book)
    {:title (first book) :author (second book)}
    (if (contains? book :title)
      book
      {:title (:book book) :author (:by book)})))

(def books [{:title "War and Peace" :author "Tolstoy"}
            {:book "Emma" :by "Austen"}
            ["1984" "Orwel"]])

(prn "1" (normalize-book (get books 0)))
(prn "1" (normalize-book (get books 1)))
(prn "1" (normalize-book (get books 2)))

(defn dispatch-book-format [book]
  (cond
    (vector? book) :vector-book
    (contains? book :title) :standard-map
    (contains? book :book) :alternative-map))

;; Multi method
(defmulti normalize-book2 dispatch-book-format)
(defmethod normalize-book2 :vector-book [book]
  {:title (first book) :author (second book)})
(defmethod normalize-book2 :standard-map [book]
  book)
(defmethod normalize-book2 :alternative-map [book]
  {:title (:book book) :author (:by book)})
(prn)
(prn "2" (normalize-book2 (get books 0)))
(prn "2" (normalize-book2 (get books 1)))
(prn "2" (normalize-book2 (get books 2)))

(def books2 [{:title "Pride and Prejudice" :author "Austen" :genre :romance}
             {:title "World War Z" :author "Books" :genre :zombie}
             {:title "Pride and Prejudice and Zombies" :author "Grahame-Smith" :genre :zombie-romance}
             {:title "The Little Prince" :author "Antonie de Saint-Exupéry"}])
(defmulti book-description :genre)
(defmethod book-description :romance [book]
  (str "The heart warming new romance by " (:author book)))
(defmethod book-description :zombie [book]
  (str "The heart consuming new zombie adventure by " (:author book)))
(defmethod book-description :zombie-romance [book]
  (str "The heart warming and consuming new zombie romance by " (:author book)))
(defmethod book-description :default [book]
  (str "The heart warming and consuming no genre book by " (:author book)))
(prn)
(prn "3" (book-description (get books2 0)))
(prn "3" (book-description (get books2 1)))
(prn "3" (book-description (get books2 2)))
(prn "3" (book-description (get books2 3)))

;; Deeply Recursive
(prn)
(prn "Deeply Recursive")
(def books-copies
  [{:title "Jaws" :copies-sold 20}
   {:title "Emma" :copies-sold 30}
   {:title "2001" :copies-sold 40}])
(defn sum-copies
  ([books] (sum-copies books 0))
  ([books total]
   (if (empty? books)
     total
     (sum-copies
       (rest books)
       (+ total (:copies-sold (first books)))))))
(prn "Sum 1:" (sum-copies books-copies))
(defn sum-copies2 [books]
  (loop [books books total 0]
    (if (empty? books)
      total
      (recur (rest books) (+ total (:copies-sold (first books)))))))
(prn "Sum 2:" (sum-copies2 books-copies))

;; using map to sum
(prn "Map " (map :copies-sold books-copies))
(prn "Sum 3:" (apply + (map :copies-sold books-copies)))

;; Docstring
(prn)
(prn "Docstring")
;; Return the average of the two parameters
(defn average [a b]
  "Return the average of the two parameters"
  (/ (+ a b) 2))
(prn (average 1 5))
(prn (average 1 6))
;; (doc average)
(defn multi-average
  "Return the average of two or three numbers."
  ([a b] (/ (+ a b) 2))
  ([a b c] (/ (+ a b c) 3)))
(prn (multi-average 2 8))
(prn (multi-average 3 6 9))
(prn (multi-average 3 6 10))

;; Pre and Pos conditions
(prn)
(prn "Pre and Pos conditions")
;; Publish a book using the (unseen) print-book
;; and ship-book functions.

(defn print-book [book] (prn (str "print-book: " book)))
(defn ship-book [book] (prn (str "ship-book: " book)))
(defn publish-book [book]
  (when-not (contains? book :title)
    (throw (ex-info "Book must contain :title" {:book book})))
  (print-book book)
  (ship-book book))
(publish-book {:title "Jaws" :published-at 1965})

(try
  (publish-book {})
  (catch Exception e (prn (ex-message e))))

;(defn publish-book2 [book]
;  {:pre [(:title book)]
;   :post [(boolean? %)]}
;  (print-book book)
;  (ship-book book))
;(publish-book2 {:title "Jaws"})
;(publish-book2 {})

(defn one-two-or-more
  ([a] (println "One arg:" a))
  ([a b] (println "Two args:" a b))
  ([a b & more] (println "More then two args:" a b more)))
(one-two-or-more 1 2 3 4 5)
(defn print-any-args [& args]
  (println "My arguments are:" args))
(print-any-args 1 2 3 4)