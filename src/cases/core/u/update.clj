(ns cases.core.u.update)

;; 'Updates' a value in an associative structure, where k is a
;; key and f is a function that will take the old value
;; and any supplied args and return the new value, and returns a new
;; structure.  If the key does not exist, nil is passed as the old value.
(def p {:name "James" :age 26})

(println (pr-str (update p :age inc)))
(println (pr-str (update p :age + 10)))
(println (pr-str (update p :age - 10)))

(def empty-map nil)
(println (pr-str (update empty-map :some-key #(str "foo" %))))
(println (update [1 2 3] 0 inc))
(println (pr-str (update [] 0 #(str "foo" %))))
(println (pr-str (update [] 0 str "foo")))