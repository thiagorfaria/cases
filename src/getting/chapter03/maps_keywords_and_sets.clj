(ns getting.chapter03.maps_keywords_and_sets)

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

;; Sets
(println)
(println "Sets")
(def genres #{:sci-fi :romance :mystery})
(println genres)
(def authors #{"Dickens" "Austen" "King"})
(println (pr-str authors))

(println (contains? authors "Austen"))
(println (contains? genres "Austen"))
(println (pr-str (authors "Austen")))
(println (pr-str (:sci-fi genres)))
(println (pr-str (genres :sci-fi)))
(println (pr-str (genres :historical)))
(def more-authors (conj authors "Clarke"))
(println (pr-str more-authors))
(println (pr-str (disj more-authors "King")))

;; Stay out of trouble
(println)
(println "Stay out of trouble")
(println (pr-str (first book-keyword)))
(println (pr-str (rest book-keyword)))
(println (pr-str (count book-keyword)))