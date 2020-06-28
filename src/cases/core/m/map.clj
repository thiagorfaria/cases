(ns cases.core.m.map)

;; Returns a lazy sequence consisting of the result of applying f to
;; the set of first items of each coll, followed by applying f to the
;; set of second items in each coll, until any one of the colls is
;; exhausted.  Any remaining items in other colls are ignored. Function
;; f should accept number-of-colls arguments. Returns a transducer when
;; no collection is provided.
(def my-inc (partial + 1))
(println (map inc [1 2 3 4 5]))
(println (map my-inc [1 2 3 4 5]))

;; map can be used with multiple collections. Collections will be consumed
;; and passed to the mapping function in parallel:
(println (map + [1 2 3] [4 5 6]))

;; When map is passed more than one collection, the mapping function will
;; be applied until one of the collections runs out:
(println (map + [1 2 3] (iterate inc 1)))

;; Test
(println (map inc (take 3 (iterate inc 1))))

;; map is often used in conjunction with the # reader macro:
(println (map #(str "Hello " % "!") ["Ford" "Arthur" "Tricia"]))

;; A useful idiom to pull "columns" out of a collection of collections.
;; Note, it is equivalent to:
;; user=> (map vector [:a :b :c] [:d :e :f] [:g :h :i])
(println (apply map vector [[:a :b :c]
                            [:d :e :f]
                            [:g :h :i]]))

(println (map vector [[:a :b :c]
                      [:d :e :f]
                      [:g :h :i]]))

;; Use a hash-map as a function to translate values in a collection from the
;; given key to the associated value

(println (map {:b "two" :c "three"} [:c :b :a]))
