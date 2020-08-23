(ns cases.core.m.map
  (:require [cases.aux.title :refer :all]))

;; Returns a lazy sequence consisting of the result of applying f to
;; the set of first items of each coll, followed by applying f to the
;; set of second items in each coll, until any one of the colls is
;; exhausted.  Any remaining items in other colls are ignored. Function
;; f should accept number-of-colls arguments. Returns a transducer when
;; no collection is provided.

;; see
;;  cases.core.a.apply
;;  cases.core.i.inc
;;  cases.core.i.iterate
;;  cases.core.p.partial
;;  cases.core.s.str
;;  cases.core.t.take
;;  cases.core.vars.+

(def ^:private my-vec [1 2 3 4 5])

(title)
(def map-inc (map inc my-vec))
(prn map-inc)

(title "The same of first test example but using partial function")
(def ^:private my-inc (partial + 1))
(def my-map-inc (map my-inc my-vec))
(prn my-map-inc)

(title "map can be used with multiple collections. Collections will be consumed"
       "passed and to the mapping function in parallel:")
(def map-sum-multi-collections (map + [1 2 3] [4 5 6]))
(prn map-sum-multi-collections)

(title "When map is passed more than one collection, the mapping function will"
       "be applied until one of the collections runs out:")
(def map-sum-lazy-iterate (map + [1 2 3] (iterate inc 1)))
(prn map-sum-lazy-iterate)

(title "Testing many combinations")
(def map-inc-iterate-inc (map inc (take 3 (iterate inc 1))))
(prn map-inc-iterate-inc)

(title "map is often used in conjunction with the # reader macro:")
(def map-anonymous-fn (map #(str "Hello " % "!") ["Ford" "Arthur" "Tricia"]))
(prn map-anonymous-fn)

(title "A useful idiom to pull \"columns\" out of a collection of collections."
       "Note, it is equivalent to:"
       "user=> (map vector [:a :b :c] [:d :e :f] [:g :h :i])")
(prn (apply map vector [[:a :b :c] [:d :e :f] [:g :h :i]]))
(prn (map vector [:a :b :c] [:d :e :f] [:g :h :i]))

(title "Use a hash-map as a function to translate values in a collection from the"
       "given key to the associated value")
(def map-get-values (map {:b "two" :c "three"} [:c :b :a]))
(prn map-get-values)
