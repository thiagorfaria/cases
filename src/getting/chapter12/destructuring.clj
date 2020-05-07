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
(println "## Digging into maps")
(println)
(def artist-map {:painter :monet :novelist :austen})
(println "artist-map" artist-map)
(let [{painter :painter writer :novelist} artist-map]
  (println "The painter is:" painter)
  (println "The novelist is:" writer))

;; ## Digging into nested maps
(println "## Digging into nested maps")
(println)
(def austen {:name    "Jane Austen"
             :parents {:father "George" :mother "Cassandra"}
             :dates   {:born 1775 :died 1817}})
(prn austen)
(prn (:name austen))
(prn (:father (:parents austen)))
(prn (-> austen :parents :mother))
(let [{{dad :father mom :mother} :parents} austen]
  (println "Jane Austen's dad's name was" dad)
  (println "Jane Austen's mom's name was" mom))

(let [{name :name
       {mom :mother} :parents
       {dob :born} :dates} austen]
  (println name "was born in" dob)
  (println name "mother's name is" mom))