(ns cases.my.recursive)

;; Testing some recursive stuff

(def books
  [{:title "Jaws" :copies-sold 50 :genre :suspense}
   {:title "Emma" :copies-sold 33 :genre :romance}
   {:title "2001" :copies-sold 10 :genre :sci-fi}
   {:title "The Little Prince" :genre :novel}
   {:title "1984" :copies-sold 5 :genre :sci-fi}])

(defn total-copies
  ([books] (total-copies books 0))
  ([books total]
   (let [book (first books)
         len (count books)
         copies-sold (+ total (:copies-sold book 0))]
     (if (= 1 len) copies-sold (recur (rest books) copies-sold)))))

(prn (str "Total is " (total-copies books)))
(prn (str "Total is " (total-copies books 0)))

;; Group by probably will solve it
(defn total-by-genre
  ([books genre] (total-by-genre books 0 genre))
  ([books total genre]
   (if (empty? books)
     total
     (let [book (first books)
           is-genre (= genre (:genre book))
           rest-books (rest books)]
       (if is-genre
         (recur rest-books (+ total (:copies-sold book 0)) genre)
         (recur rest-books total genre))))))

(prn (str "Total Romance: " (total-by-genre books :romance)))
(prn (str "Total Sci-fi: " (total-by-genre books :sci-fi)))
(prn (str "Total Novel: " (total-by-genre books :novel)))
(prn (str "Total Terror: " (total-by-genre books :terror)))