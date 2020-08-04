(ns getting.chapter15.spec
  (:require [clojure.spec.alpha :as s]))

(prn "This Is the Data You’re Looking For")
(defn book? [book]
  (and
    (map? book)
    (string? (:author book))
    (string? (:title book))
    (pos-int? (:copies book))))

(def getting-clojure {:title "Getting Clojure" :author "Olsen" :copies 1000000})
(def java-how-to-programming {:title "Java how to programming" :author "Deitel"})

(prn getting-clojure)
(prn (book? getting-clojure))

(prn java-how-to-programming)
(prn (book? java-how-to-programming))

(s/valid? number? 44)
(s/valid? number? :hello)

(def number-great-than-10 (s/and number? #(> % 10)))
(prn (s/valid? number-great-than-10 1))
(prn (s/valid? number-great-than-10 10))
(prn (s/valid? number-great-than-10 11))

(def number-or-string (s/or :a-number string? :a-string string?))
(prn (s/valid? number-or-string "Hello"))
(prn (s/valid? number-or-string 99))
(prn (s/valid? number-or-string 'foo))

(def number-great-than-10-or-symbol (s/or :greater number-great-than-10 :a-symbol symbol?))
(prn (s/valid? number-great-than-10-or-symbol "Hello"))
(prn (s/valid? number-great-than-10-or-symbol 99))
(prn (s/valid? number-great-than-10-or-symbol 'foo))
