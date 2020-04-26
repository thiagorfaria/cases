(ns getting.chapter06.example)

;; Functions are values
(prn "Functions are values")
(def dracula {:title  "Dracula"
              :author "Stoker"
              :price  1.99
              :genre  :horror})

(defn cheap? [book]
  (<= (:price book) 9.99))

(defn pricey? [book]
  (> (:price book) 9.99))

(prn (str "Is Dracula cheap ? " (cheap? dracula)))
(prn (str "Is Dracula pricey ? " (pricey? dracula)))

(defn horror? [book]
  (= (:genre book) :horror))

(defn adventure? [book]
  (= (:genre book) :adventure))

(prn (str "Is Dracula a horror genre? " (horror? dracula)))
(prn (str "Is Dracula a adventure genre? " (adventure? dracula)))

(defn cheap-horror? [book]
  (and (cheap? book) (horror? book)))
(defn pricey-adventure? [book]
  (and (pricey? book) (adventure? book)))

(prn (str "Is Dracula a horror genre and cheap? " (cheap-horror? dracula)))
(prn (str "Is Dracula a adventure genre and pricey? " (pricey-adventure? dracula)))

(prn (type (cheap? dracula)))
(def reasonable-value? cheap?)
(prn (str "Is Dracula a reasonable value? " (reasonable-value? dracula)))

(defn run-with-dracula [f]
  (f dracula))
(prn (str "Run with dracula function is cheap? " (run-with-dracula cheap?)))
(prn (str "Run with dracula function is pricey? " (run-with-dracula pricey?)))

(defn both?
  [first-predicate-f second-predicate-f book]
  (and (first-predicate-f book) (second-predicate-f book)))

(prn (str "Predicate: Is Dracula a horror genre and cheap? " (both? cheap? horror? dracula)))
(prn (str "Predicate: Is Dracula a adventure genre and pricey? " (both? pricey? adventure? dracula)))

;; Functions on the Fly
(prn)
(prn "Functions on the Fly")
(println "A function:" (fn [n] (* 2 n)))
(println "A function:" ((fn [n] (* 2 n)) 10))
(def double-it (fn [n] (* 2 n)))
(println "Double it: " (double-it 2))

(println "fn testing: > 9.99 " ((fn [book] (<= (:price book) 9.99)) {:price 10.19}))
(println "fn testing <= 9.99: " ((fn [book] (<= (:price book) 9.99)) {:price 9.35}))

;; function that produce function
(def book-no-title {:price 0.99 :genre :horror})
(prn)
(prn "book-no-title" book-no-title)
(defn cheaper-f [max-price]
  (fn [book]
    (<= (:price book) max-price)))

(def real-cheap? (cheaper-f 1.00))
(def kind-of-cheap? (cheaper-f 1.99))
(def marginally-cheap? (cheaper-f 5.99))
(println "real-cheap?:" (real-cheap? book-no-title))
(println "kind-of-cheap?:" (kind-of-cheap? book-no-title))
(println "marginally-cheap?:" (marginally-cheap? book-no-title))

(defn both-f [predicate-f-1 predicate-f-2]
  (fn [book]
    (and (predicate-f-1 book) (predicate-f-2 book))))
(def cheap-horror2? (both-f cheap? horror?))
(def real-cheap-adventure? (both-f real-cheap? adventure?))
(def real-cheap-horror? (both-f real-cheap? horror?))

(println "cheap-horror2?" (cheap-horror2? book-no-title))
(println "real-cheap-adventure?" (real-cheap-adventure? book-no-title))
(println "real-cheap-horror?" (real-cheap-horror? book-no-title))

(def possession {:title "Possession" :price 0.89 :genre :horror})
(prn)
(println "Possession book:" possession)
(def cheap-horror-possession?
  (both-f cheap-horror2?
          (fn [book] (= (:title book) "Possession"))))

(println "cheap-horror-possession?" (cheap-horror-possession? possession))
(prn)
(prn "A Functional Toolkit")
(println "1 2 3 4 = " (+ 1 2 3 4))
(def the-function +)
(def args [1 2 3 4])
(println "apply + [1 2 3 4]" (apply the-function args))
(println "apply + [1 2 3 4]" (apply + [1 2 3 4]))

(prn)
(def v ["The number " 2 " best selling " "book."])
(println (str v))
(prn "apply str" (apply str v))
(prn "apply list" (apply list v))
(prn "apply vector list" (apply vector (apply list v)))

(prn)
(defn my-inc [n] (+ 1 n))
(println "my inc 10 =" (my-inc 10))
(def my-inc2 (partial + 1))
(println "my inc (partial) 10 =" (my-inc2 10))

(defn cheaper-than [max-price book]
  (<= (:price book) max-price))

(def real-cheap? (partial cheaper-than 1.00))
(def kind-of-cheap? (partial cheaper-than 1.99))
(def marginally-cheap? (partial cheaper-than 5.99))

;; my test
(def hello (partial str "Hello " "mister "))
(println (hello "world!"))

(defn not-adventure? [book] (not (adventure? book)))
(println dracula)
(println "Dracula is not a adventure book?" (not-adventure? dracula))
(def not-adventure2? (complement adventure?))
(println "Dracula is not a adventure book?" (not-adventure2? dracula))
