(ns cases.core.a.assoc-in)

;; Associates a value in a nested associative structure, where ks is a
;; sequence of keys and v is the new value and returns a new nested structure.
;; If any levels do not exist, hash-maps will be created.
(def users [{:name "James" :age 26} {:name "John" :age 43}])
(prn users)
(prn (assoc-in users [1 :age] 44))
(prn (assoc-in users [1 :password] "nhoJ"))
(prn (assoc-in users [2] {:name "Jack" :age 19}))

(def person {:person {:name "Mike"}})
(prn (assoc-in person [:person :name] "Violet"))
(prn (assoc-in person [:person] "Violet"))
(prn (assoc-in [person] [0 :person :name] "Violet"))
(prn (assoc-in [{:person {:name ["Mike"]}}]
               [0 :person :name 1] "Smith"))

;; My test
(def my-map {:a {:b {:c {:d "create-a-map"}}}})
(prn my-map)
(prn (assoc-in my-map [:a :b :c :d] "modify-a-map"))
(prn (assoc-in my-map [:a :b :c :e] "modify-a-map"))
(prn (:d (:c (:b (:a my-map)))))
(prn (-> my-map :a :b :c :d))