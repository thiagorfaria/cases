(ns getting.chapter04.example)

;; The Fundamental If
(println "The Fundamental If")
(defn print-greeting [preferred-customer]
  (if preferred-customer
    "Welcome back to Blotts Books!"))
(println (print-greeting true))
(println (print-greeting false))

(defn print-greeting2 [preferred-customer]
  (if preferred-customer
    "Welcome back to Blotts Books!"
    "Welcome to Blotts Books!"))
(println (print-greeting2 true))
(println (print-greeting2 false))

(defn shipping-charge [preferred-customer order-amount]
  (if preferred-customer
    0.00
    (* order-amount 0.10)))
(println (shipping-charge true 10.00))
(println (shipping-charge false 10.00))

;; Asking Questions
(println)
(println "Asking Questions")
(println "(= 1 1)" (= 1 1))
(println "(= 2 (+ 1 1))" (= 2 (+ 1 1)))
(println "(= \"Anna Karenina\" \"Jane Eyre\")" (= "Anna Karenina" "Jane Eyre"))
(println "(= \"Emma\" \"Emma\")" (= "Emma" "Emma"))
(println "(= 2 2 2 2 2 2 2 2 2 2 2 2 2)" (= 2 2 2 2 2 2 2 2 2 2 2 2 2))
(println "(= 2 2 2 2 2 2 2 3 2 2 2 2 2)" (= 2 2 2 2 2 2 2 3 2 2 2 2 2))
(println "(= (+ 2 2) (/ 40 10) (* 2 2) (- 5 1))" (= (+ 2 2) (/ 40 10) (* 2 2) (- 5 1)))
(println "(not= \"Anna Karenina\" \"Jane Eyre\")" (not= "Anna Karenina" "Jane Eyre"))
(println "(not= \"Anna Karenina\" \"Anna Karenina\")" (not= "Anna Karenina" "Anna Karenina"))
(defn greet-and-smaller [a b c]
  (println "a=" a "b=" b "c=" c)
  (if (> a b)
    (println "a is bigger than b"))
  (if (< b c)
    (println "b is smaller than c")))
(greet-and-smaller 3 2 4)
(println "(number? 1984)" (number? 1984))
(println "(number? \"Anna Karenina\")" (number? "Anna Karenina"))
(println "(string? \"Anna Karenina\")" (string? "Anna Karenina"))
(println "(keyword? \"Anna Karenina\")" (keyword? "Anna Karenina"))
(println "(keyword? :anna-karenina)" (keyword? :anna-karenina))
(println "(map? :anna-karenina)" (map? :anna-karenina))
(println "(map? {:title 1984})" (map? {:title 1984}))
(println "(vector? 1984)" (vector? 1984))
(println "(vector? [1984])" (vector? [1984]))
(defn shipping-surcharge [preferred-customer express oversized]
  (if (and (not preferred-customer) (or express oversized))
    "surcharge" "no surcharge"))
(println (shipping-surcharge true false false))
(println (shipping-surcharge false true false))
(println (shipping-surcharge false false true))
(println (shipping-surcharge false true true))
(println (shipping-surcharge false false false))

;; Do and when
(println)
(println "Do and when")
(println (do
           (println "This is four expressions.")
           (println "All grouped together as one")
           (println "That prints some stuff and then evaluates to 44")
           44))
(defn shipping-charge2 [preferred-customer order-amount]
  (if preferred-customer
    (do
      (println "Preferred customer, free shipping!")
      0.0)
    (do
      (println "Regular customer, charge them for shipping")
      (* order-amount 0.10))))
(println (shipping-charge2 true 100))
(println (shipping-charge2 false 100))
(println)
(let [preferred-customer true]
  (when preferred-customer
    (println "Hello returning customer!")
    (println "Welcome back to Blotts Books!")))

;; Dealing with multiple conditions
(println)
(println "Dealing with multiple conditions")
(defn shipping-charge3 [preferred-customer order-amount]
  (if preferred-customer
    0.0
    (if (< order-amount 50.0)
      5.0
      (if (< order-amount 100.0)
        10.0
        (* 0.1 order-amount)))))
(println "3" (shipping-charge3 true 100))
(println "3" (shipping-charge3 false 45))
(println "3" (shipping-charge3 false 85))
(println "3" (shipping-charge3 false 105))
(println)
(defn shipping-charge4 [preferred-customer order-amount]
  (cond
    preferred-customer 0.0
    (< order-amount 50.0) 5.0
    (< order-amount 100.0) 10.0
    (>= order-amount 100.0) (* 0.1 order-amount)))
(println "4" (shipping-charge4 true 100))
(println "4" (shipping-charge4 false 45))
(println "4" (shipping-charge4 false 85))
(println "4" (shipping-charge4 false 105))
(println)
(defn shipping-charge5 [preferred-customer order-amount]
  (cond
    preferred-customer 0.0
    (< order-amount 50.0) 5.0
    (< order-amount 100.0) 10.0
    :else (* 0.1 order-amount)))
(println "5" (shipping-charge5 true 100))
(println "5" (shipping-charge5 false 45))
(println "5" (shipping-charge5 false 85))
(println "5" (shipping-charge5 false 105))
(println)
(defn customer-greeting [status]
  (case status
    :gold "Welcome, welcome, welcome back!!"
    :preferred "Welcome back!"
    "Welcome to Blotts Books"))
(println (customer-greeting :gold))
(println (customer-greeting :preferred))
(println (customer-greeting nil))

;;Throwing and catching
(println)
(println "Throwing and catching")

(try
  (/ 0 0)
  (catch ArithmeticException e (println "Math problem."))
  (catch StackOverflowError e (println "Unable to publish..")))
(defn publish-book [book]
  (when (not (:title book))
    (throw
      (ex-info "A book needs a title!" {:book book}))))
(try
  (publish-book {})
  (catch Exception e (prn e)))