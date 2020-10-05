(ns applied.ch01.apollo)

(defn- make-mission
  [name system launched manned? opts]
  (let [{:keys [cm-name                                     ;; command module
                lm-name                                     ;; lunar module
                orbits
                evas]} opts]
    {:name     name
     :system   system
     :launched launched
     :manned   manned?
     :cm-name  cm-name
     :lm-name  lm-name
     :orbits   orbits
     :evas     evas}))

(def ^:private mission-defaults {:orbits 0 :evas 0})

(defn- make-mission-2
  [name system launched manned? opts]
  (let [{:keys [cm-name                                     ;; command module
                lm-name                                     ;; lunar module
                orbits
                evas]} (merge mission-defaults opts)]
    {:name     name
     :system   system
     :launched launched
     :manned   manned?
     :cm-name  cm-name
     :lm-name  lm-name
     :orbits   orbits
     :evas     evas}))

(defn- make-mission-3
  [name system launched manned? & opts]
  (let [{:keys [cm-name                                     ;; command module
                lm-name                                     ;; lunar module
                orbits
                evas]} opts]
    {:name     name
     :system   system
     :launched launched
     :manned   manned?
     :cm-name  cm-name
     :lm-name  lm-name
     :orbits   orbits
     :evas     evas}))

(defn- make-mission-4
  [name system launched manned? & opts]
  (let [{:keys [cm-name                                     ;; command module
                lm-name                                     ;; lunar module
                orbits
                evas]
         :or   {cm-name "" lm-name "" orbits 0 evas 0}} opts] ;; default to 0
    {:name     name
     :system   system
     :launched launched
     :manned   manned?
     :cm-name  cm-name
     :lm-name  lm-name
     :orbits   orbits
     :evas     evas}))

(def apollo-4-mission-1
  (make-mission "Apollo 4"
                "Saturn V"
                #inst "1967-11-09T12:00:01-00:00"
                false
                {:orbits 3}))

(def apollo-4-mission-2
  (make-mission-2 "Apollo 4"
                  "Saturn V"
                  #inst "1967-11-09T12:00:01-00:00"
                  false
                  {:orbits 3}))

(def apollo-4-mission-3
  (make-mission-3 "Apollo 4"
                  "Saturn V"
                  #inst "1967-11-09T12:00:01-00:00"
                  false
                  :orbits 3))

(def apollo-4-mission-4
  (make-mission-4 "Apollo 4"
                  "Saturn V"
                  #inst "1967-11-09T12:00:01-00:00"
                  false
                  :orbits 3))

(def apollo-11-mission-3
  (make-mission-3 "Apollo 11"
                  "Saturn V"
                  #inst "1967-07-16T13:32:00-00:00"
                  true
                  :cm-name "Columbia"
                  :lm-name "Eagle"
                  :orbits 30
                  :evas 1))


(defn- euclidean-norm [ecc-vector] ecc-vector)

(defrecord Planet [name
                   moons
                   volume
                   mass
                   aphelion
                   perihelion
                   orbital-eccentricity])

(defn- make-planet
  "Make a planet from field values and an eccentricity vector"
  [name moons volume mass aphelion perihelion ecc-vector]
  (->Planet name moons volume mass aphelion perihelion (euclidean-norm ecc-vector)))

(def earth (make-planet "Earth" 1 1000000 1000000 123 123 [:a :b :c]))
