(ns getting.chapter03.example)

;; This goes with that
(println "This goes with that")
(def book {"tile" "Oliver Twist" "author" "Dickens" "published" 1838})
(println (pr-str book))

(println (pr-str (hash-map "title" "Oliver Twist" "author" "Dickens" "published" 1838)))

(println (get book "published"))
(println (book "published"))

;; Keywords
(println)
(println "Keywords")
(def book-keyword {:title "Oliver Twist" :author "Dickens" :published 1838})
(println "Title:" (book-keyword :title))
(println "Author:" (:author book-keyword))
(println "Published:" (book-keyword :published))

;; Changing your map without changing it
(println)
(println "Changing your map without changing it")
(println (pr-str (assoc book-keyword :page-count 362)))
(println (pr-str (assoc book-keyword :page-count 362 :title "War & Peace")))
(println (pr-str (dissoc book-keyword :published)))
(println (pr-str (dissoc book-keyword :published :title :author)))
(println (pr-str (dissoc book-keyword :paperback :illustrator :favorite-zoo-animal)))

;; Other handy map function
(println)
(println "Other handy map function")
(println (keys book-keyword))
(println (pr-str (vals book-keyword)))
(def book-sorted (sorted-map :title "Oliver Twist" :author "Dickens" :published 1838))
(println (pr-str book-sorted))
(println (keys book-sorted))
(println (pr-str (vals book-sorted)))