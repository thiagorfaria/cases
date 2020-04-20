(ns cases.core.u.update-in)

;; 'Updates' a value in a nested associative structure, where ks is a
;; sequence of keys and f is a function that will take the old value
;; and any supplied args and return the new value, and returns a new
;; nested structure.  If any levels do not exist, hash-maps will be
;; created.
(def users-map {:person1 {:name "James" :age 26}  :person2 {:name "John" :age 43}})
(println (pr-str (update-in users-map [:person1 :age] inc)))

(def users-map [{:name "James" :age 26} {:name "John" :age 43}])
(println (pr-str (update-in users-map [0 :age] inc)))

(println (update-in [1 2 [[1 3 4 1] 2 3]] [2 0 3] inc))