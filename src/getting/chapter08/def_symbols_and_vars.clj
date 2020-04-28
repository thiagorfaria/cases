(ns getting.chapter08.def-symbols-and-vars)

;; ## A Global, Stable Place for Your Stuff
(println "## A Global, Stable Place for Your Stuff")

(def title "Emma")
(println "Title:" title)

(def PI 3.1415)
(def ISBN-LENGTH 13)
(def COMPANY-NAME "Blotts Books")

(println "Everyone's favorite universal constant (PI):" PI)
(println "Length of a standard book ID. (ISBN length):" ISBN-LENGTH)
(println "Company names are more or less constant:" COMPANY-NAME)

(println)
(println "Def vs Defn")
(def book {:title "Jaws" :author "Peter Benchley"})
(defn book-description [book]
  (str (:title book) " write by " (:author book)))

(def book-description2
  (fn [book]
    (str (:title book) " write by " (:author book))))

(println (book-description book))
(println (book-description2 book))

(println)
(println "Using Def inside Def and Defn")
(def OLD-ISBN-LENGTH 10)
(println "Before 2007 ISBNs were 10 characters long." OLD-ISBN-LENGTH)
(def isbn-length [OLD-ISBN-LENGTH ISBN-LENGTH])
(println isbn-length)

(defn valid-isb [isbn]
  (or (= (count isbn) OLD-ISBN-LENGTH)
      (= (count isbn) ISBN-LENGTH)))
(println "Is Jaws ISBN valid?" (valid-isb "9783550085970"))
(println "Is Jaws ISBN valid?" (valid-isb "9783550085"))
(println "Is Jaws ISBN valid?" (valid-isb "978355008"))

;; ## Symbols are Things
(println)
(println "## Symbols are Things")
(def author "Austen")
(println "Author:" author)
(println "Turn symbol in a string:" 'author)
(println "What means single quote ' " (type 'author))

;; Bindings are things too
(println)
(println "## Bindings are things too.")
(def the-var #'author)
(println "Punchline, the var that binds the symbol to the value (#') the-var:" the-var)
(println (.get the-var))
(println (.-sym the-var))

;; ## Varying your vars
(println)
(println "## Varying your vars")
(def ^:dynamic *debug-enabled* false)
(defn debug [msg]
  (if *debug-enabled*
    (println msg)))

(binding [*debug-enabled* true]
  (debug (str "Calling that darned function: " *debug-enabled*)))

;(set! *debug-enabled* true)

(println (str "It works because var was changed: " *debug-enabled*))
(debug (str "It works because var was changed: " *debug-enabled*))
