(ns getting.chapter14.test
  (:require [clojure.spec.gen.alpha :as gen]
            [clojure.test.check.generators :as check.generators]
            [clojure.test.check.properties :as check.properties]
            [clojure.test.check :as check]))

(prn "Spotting Bugs with clojure.test")
(defn find-by-title
  "Search for a book by title,
  where title is a string and books is a collection
  of book maps, each of which must have a :title entry"
  [title books]
  (some #(when (= (:title %) title) %) books))

(defn number-of-copies-of
  "Return the number of copies in inventory of the
  given title, where title is a string and books is a collection
  of book maps each of which must have a :title entry"
  [title books]
  (:copies (find-by-title title books)))

(prn)
(prn "Property-Based Testing")
(prn (check.generators/sample check.generators/string-alphanumeric))

(def title-generated (check.generators/such-that not-empty check.generators/string-alphanumeric))
(def author-generated (check.generators/such-that not-empty check.generators/string-alphanumeric))
(def copies-generated (check.generators/such-that (complement zero?) check.generators/nat))

(prn title-generated)
(prn author-generated)
(prn copies-generated)

(def book-generated
  (check.generators/hash-map :title title-generated :author author-generated :copies copies-generated))
(prn book-generated)

(def inventory-generated (check.generators/not-empty (gen/vector book-generated)))
(prn inventory-generated)

(def inventory-and-book-generated
  (check.generators/let [inventory inventory-generated
                         book (check.generators/elements inventory)]
                        {:inventory inventory :book book}))
(prn inventory-and-book-generated)

(prn)
(prn "Checking Properties")
(prn (check.properties/for-all [i check.generators/nat]
                               (< i (inc i))))

(prn (check/quick-check 50
                        (check.properties/for-all [i check.generators/nat]
                                                  (< i (inc i)))))