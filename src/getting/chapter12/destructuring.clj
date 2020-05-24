(ns getting.chapter12.destructuring)

;; ## Pry open your data
(println "## Pry open your data")
(def artists [:monet :austin])
(println "artists:" artists)

(let [painter (first artists)
      novelist (second artists)]
  (println "The painter is:" painter "and novelist is:" novelist))

(let [[painter novelist] artists]
  (println "The painter is:" painter "and novelist is:" novelist "\n"))

(def artists2 [:monet :austin :beethoven :dickinson])
(println "artists:" artists2)

(let [[painter novelist composer poet] artists2]
  (println "The painter is:" painter)
  (println "The novelist is:" novelist)
  (println "The composer is:" composer)
  (println "The poet is:" poet "\n"))

;; ## Get less then everything
(println "## Get less then everything")
(println)

(let [[_ _ composer poet] artists2]
  (println "The composer is:" composer)
  (println "The poet is:" poet "\n"))

(def pairs [[:monet :austin] [:beethoven :dickinson] :bono])
(println "artists:" pairs)

(let [[[painter] [composer poet] singer] pairs]
  (println "The painter is:" painter)
  (println "The composer is:" composer)
  (println "The poet is:" poet)
  (println "The singer is:" singer "\n"))

;; ## Destructuring in Sequence
(println "## Destructuring in Sequence")
(println)
(def artists-list '(:monet :austin :beethoven :dickinson))
(println "artists:" artists-list)

(let [[painter _ composer poet] artists-list]
  (println "The painter is:" painter)
  (println "The composer is:" composer)
  (println "The poet is:" poet "\n"))

(let [[c1 c2 c3 c4] "Jane"]
  (println "How spell Jane?")
  (println c1)
  (println c2)
  (println c3)
  (println c4)
  (println))

;; ## Destructuring functions arguments
(println "## Destructuring functions arguments")
(println)
(defn artist-description [[novelist poet]]
  (str "The novelist is" novelist " and the poet is" poet))

(println (artist-description [:austen :dickinson]))

(defn artist-description2 [shout [novelist poet]]
  (let [msg (str "Novelist is" novelist " and the poet is" poet)]
    (if shout (.toUpperCase msg) msg)))

(println (artist-description2 true [:austen :dickinson]))
(println (artist-description2 false [:austen :dickinson]))

;; ## Digging into maps
(println)
(println "## Digging into maps")
(println)
(def artist-map {:painter :monet :novelist :austen})
(println "artist-map" artist-map)
(let [{painter :painter writer :novelist} artist-map]
  (println "The painter is:" painter)
  (println "The novelist is:" writer))

;; ## Digging into nested maps
(println)
(println "## Digging into nested maps")
(println)
(def austen {:name    "Jane Austen"
             :parents {:father "George" :mother "Cassandra"}
             :dates   {:born 1775 :died 1817}})
(prn austen)
(prn (:name austen))
(prn (:father (:parents austen)))
(prn (-> austen :parents :mother))
(prn (:mother (:parents austen)))
(let [{parents :parents} austen]
  (prn parents)
  (let [{dad :father mom :mother} parents]
    (println "Jane Austen's dad's name was" dad)
    (println "Jane Austen's mom's name was" mom)))
(let [{{dad :father mom :mother} :parents} austen]
  (println "Jane Austen's dad's name was" dad)
  (println "Jane Austen's mom's name was" mom))

(let [{name                      :name
       {mom :mother dad :father} :parents
       {dob :born}               :dates} austen]
  (println name "was born in" dob)
  (println name "mother's name is" mom)
  (println name "father's name is" dad))

;; ## The final frontier: Mixing and Matching
(println)
(println "## The final frontier: Mixing and Matching")
(println)

(def author {:name  "Jane Austen"
             :books [{:title "Sense and Sensibility" :published 1811}
                     {:title "Emma" :published 1815}]})
(prn author)

(let [{name :name [_ book] :books} author]
  (println "The author is" name)
  (println "One of the author's books is" book))

(def authors [{:name "Jane Austen" :born 1775}
              {:name "Charles Dickens" :born 1812}])
(prn authors)

(let [[{dob-1 :born} {dob-2 :born}] authors]
  (println "One author was born in" dob-1)
  (println "The other author was born in" dob-2))

(println)
; ## Going further
(println "## Going further")
(println)

(def romeo {:name "Romeo" :age 16 :gender :male})
(prn romeo)
(defn character-desc [{name :name age :age gender :gender}]
  (str "Name: " name " age: " age " gender: " gender))
(println (character-desc romeo))

(defn character-desc2 [{:keys [name age gender]}]
  (str "Name: " name " age: " age " gender: " gender))
(println (character-desc2 romeo))

(defn character-desc3 [{:keys [name gender] age-in-year :age}]
  (str "Name: " name " age: " age-in-year " gender: " gender))
(println (character-desc3 romeo))

(defn add-greeting [character]
  (let [{:keys [name age]} character]
    (assoc character :greeting (str "Hello, my name is " name " and I am " age "!"))))
(prn (add-greeting romeo))

(defn add-greeting2 [{:keys [name age] :as character}]
  (assoc character :greeting (str "Hello, my name is " name " and I am " age "!")))
(prn (add-greeting2 romeo))

;## Staying out of trouble
(println)
(println "## Staying out of trouble")
(println)

(def favorite-books [{:name "Charlie" :fav-book {:title "Carrie" :author ["Stephen" "King"]}}
                     {:name "Jennifer" :fav-book {:title "Emma" :author ["Jane" "Austen"]}}])

(prn favorite-books)

(defn format-a-name [[_ {{[first-name last-name] :author} :fav-book}]]
  (str first-name " " last-name))
(println (format-a-name favorite-books))

(defn format-a-name-better [[_ second-reader]]
  (let [author (-> second-reader :fav-book :author)]
    (str (first author) " " (second author))))

(println (format-a-name-better favorite-books))t