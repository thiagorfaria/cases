(ns cases.core.a.assoc-in)

;; Associates a value in a nested associative structure, where ks is a
;; sequence of keys and v is the new value and returns a new nested structure.
;; If any levels do not exist, hash-maps will be created.
(def users [{:name "James" :age 26} {:name "John" :age 43}])
(println (pr-str users))
(println (pr-str (assoc-in users [1 :age] 44)))
(println (pr-str (assoc-in users [1 :password] "nhoJ")))
(println (pr-str (assoc-in users [2] {:name "Jack" :age 19})))

(def person {:person {:name "Mike"}})
(println (pr-str (assoc-in person [:person :name] "Violet")))
(println (pr-str (assoc-in person [:person] "Violet")))
(println (pr-str (assoc-in [person] [0 :person :name] "Violet")))
(println (pr-str (assoc-in [{:person {:name ["Mike"]}}] [0 :person :name 1] "Smith")))

;; My test
(def my-map {:a {:b {:c {:d "create-a-map"}}}})
(println (pr-str my-map))
(println (pr-str (assoc-in my-map [:a :b :c :d] "modify-a-map")))
(println (pr-str (assoc-in my-map [:a :b :c :e] "modify-a-map")))
(println (pr-str (:d (:c (:b (:a my-map))))))
(println (pr-str (-> my-map :a :b :c :d)))