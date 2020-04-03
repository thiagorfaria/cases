(ns cases.j.ex_juxt
  (:use clojure.pprint))

;; Takes a set of functions and returns a fn that is the juxtaposition
;; of those fns.  The returned fn takes a variable number of args, and
;; returns a vector containing the result of applying each fn to the
;; args (left-to-right).
;; ((juxt a b c) x) => [(a x) (b x) (c x)]

;; Extract values from a map, treating keywords as functions.
(pprint (type (juxt :a :b)))
(println ((juxt :a :b) {:a 1 :b 2 :c 3 :d 4}))
(println ((juxt :a) {:a 1 :b 2 :c 3 :d 4}))

(defn identify-name [x] [(identity x) (name x)])
(println (identify-name :test))

(println (into {} (map (juxt identity name) [:a :b :c :d])))

