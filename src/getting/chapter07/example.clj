(ns getting.chapter07.example)

;; ## A Local, Temporary Place for Your Stuff
(prn "## A Local, Temporary Place for Your Stuff")
(defn compute-discount-amount [amount discount-percent min-charge]
  (if (> (* amount (- 1.0 discount-percent)) min-charge)
    (* amount (- 1.0 discount-percent))
    min-charge))
(println "1" (compute-discount-amount 100 0.90 80))
(println "1" (compute-discount-amount 100 0.10 95))

(defn compute-discount-amount2 [amount discount-percent min-charge]
  (def discount-amount (* amount (- 1.0 discount-percent))) ;
  (if (> discount-amount min-charge)
    discount-amount
    min-charge))

(println)
(println "2" (compute-discount-amount2 100 0.25 70))
(println "2" (compute-discount-amount2 100 0.10 95))
(println (type discount-amount))

(defn compute-discount-amount3 [amount discount-percent min-charge]
  (let [discount (* amount discount-percent)
        discount-amount (- amount discount)]
    (println "Discount" discount)
    (println "Discounted amount" discount-amount)
    (if (> discount-amount min-charge)
      discount-amount
      min-charge)))

(println)
(println "3" (compute-discount-amount3 100 0.25 70))
(println "3" (compute-discount-amount3 100 0.10 95))

;; ## Let Over Fn
(println)
(println "## Let Over Fn")
(def user-discount
  {"Nicholas" 0.10 "Jonathan" 0.07 "Felicia" 0.05})
(println "Print user discounts" (prn-str user-discount))

(defn compute-discount-amount4 [amount user-name user-discount min-charge]
  (let [discount-percent (user-discount user-name)
        discount (* amount discount-percent)
        discount-amount (- amount discount)]
    (if (> discount-amount min-charge)
      discount-amount
      min-charge)))

(println)
(println "4" (compute-discount-amount4 100 "Jonathan" user-discount 70))
(println "4" (compute-discount-amount4 100 "Jonathan" user-discount 95))
(println "4" (compute-discount-amount4 100 "Felicia" user-discount 70))
(println "4" (compute-discount-amount4 100 "Felicia" user-discount 99))
(println "4" (compute-discount-amount4 100 "Nicholas" user-discount 70))
(println "4" (compute-discount-amount4 100 "Nicholas" user-discount 91))

;; TODO see again
(defn mk-discount-price-f [user-name]
  (let [discount-percent (user-discount user-name)]
    (fn [amount min-charge]
      (let [discount (* amount discount-percent)
            discount-amount (- amount discount)]
        (if (> discount-amount min-charge)
          discount-amount
          min-charge)))))

(def compute-felicia-price (mk-discount-price-f "Felicia"))

(println)
(println "5" (compute-felicia-price 11 10))
(println "5" (compute-felicia-price 10 10))

;; ## Variations on the Theme
(println)
(println "## Variations on the Theme")
(def anonymous-book {:title "Sir Gawain and the Green Knight"})
(println "Anonymous Book" (pr-str anonymous-book))
(def with-author {:title "Once and Future King" :author "White"})
(println "With author" (pr-str with-author))

(defn uppercase-author [book]
  (let [author (:author book)]
    (if author (.toUpperCase author))))

(println "1" (uppercase-author with-author))
(println "1" (uppercase-author anonymous-book))

(defn uppercase-author2 [book]
  (if-let [author (:author book)]
    (.toUpperCase author)
    "ANONYMOUS"))

(println)
(println "2" (uppercase-author2 with-author))
(println "2" (uppercase-author2 anonymous-book))

(defn uppercase-author3 [book]
  (when-let [author (:author book)]
    (.toUpperCase author)))

(println)
(println "3" (uppercase-author3 with-author))
(println "3" (uppercase-author3 anonymous-book))
