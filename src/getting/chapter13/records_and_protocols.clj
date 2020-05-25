(ns getting.chapter13.records-and-protocols)

;; ## The trouble with maps
(println "## The trouble with maps")

(defn get-watson-1 [] {:name "John Watson" :appears-in "Sing of the four" :author "Doyle"})
(defn get-watson-2 [] {:cpu "Power7" :no-cpus 2880 :storage-gb 4000})

(let [watson-1 (get-watson-1)
      watson-2 (get-watson-2)]
  (prn watson-1)
  (prn watson-2))

;; ## Striking a more specific bargain with records
(println)
(println "## Striking a more specific bargain with records")

(defrecord FictionalCharacter [name appears-in author])

(def watson (->FictionalCharacter "John Watson" "Sign of the four" "Doyle"))
(prn watson)

(def elizabeth (map->FictionalCharacter {:name "Elizabeth Bennet" :appears-in "Pride & Prejudice" :author "Austen"}))
(prn elizabeth)

;; ##Records are maps
(println)
(println "## Records are maps")
(prn (:name elizabeth))
(prn (:appears-in watson))
(println (count elizabeth))
(println (keys watson))

(def specific-watson (assoc watson :appears-in " Sing of the Four"))
(prn specific-watson)

(def more-about-watson (assoc watson :address "221B Baker Street"))
(prn more-about-watson)

;; ##The records advantage
(println)
(println "## The records advantage")

(defrecord SuperComputer [cpu no-cpus storage-gb])

(prn (instance? FictionalCharacter watson))
(prn (instance? SuperComputer watson))

;; ## Protocols
(println)
(println "## Protocols")

(defrecord Employee [first-name last-name department])

(def alice (Employee. "Alice" "Smith" "Engineering"))
(defprotocol Person
  (full-name [this])
  (greeting [this message])
  (description [this]))

(defrecord FictionalCharacter2 [name appears-in author]
  Person
  (full-name [this] (:name this))
  (greeting [this msg] (str msg " " (:name this)))
  (description [this] (str (:name this) " is a character in " (:appears-in this))))

(defrecord Employee2 [first-name last-name department]
  Person
  (full-name [this] (str first-name " " (:last-name this)))
  (greeting [this msg] (str msg " " (:first-name this)))
  (description [this] (str (:first-name this) " works in " department)))

(def sofia (Employee2. "Sofia" "Diego" "Finance"))
(def sam (FictionalCharacter2. "Sam Weller" "The pickwick papers" "Dickens"))

(prn (full-name sofia))
(prn (full-name sam))
(prn (greeting sofia "Hello!"))
(prn (greeting sam "Hi!"))
(prn (description sofia))
(prn (description sam))

;; ## Decentralized polymorphism
(println)
(println "## Decentralized polymorphism")

(defprotocol Marketable (make-slogan [this]))

(extend-protocol Marketable
  Employee2
  (make-slogan [e] (str (:first-name e) " is the BEST employee!"))
  FictionalCharacter2
  (make-slogan [fc] (str (:name fc) " is the GREATEST character!"))
  SuperComputer
  (make-slogan [sc] (str "This computer has " (:no-cpus sc) " CPUs!")))

(println (make-slogan sofia))
(println (make-slogan sam))
(println (make-slogan (->SuperComputer "2" "2" 400)))

;; ## Record Confusion
(println)
(println "## Record Confusion")
