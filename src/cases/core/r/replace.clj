(ns cases.core.r.replace)

;; Given a map of replacement pairs and a vector/collection, returns a
;; vector/seq with any elements = a key in smap replaced with the
;; corresponding val in smap.  Returns a transducer when no collection
;; is provided.

(println "replace vector of keyword to vector o numbers =>"
         (pr-str (replace [:zeroth :first :second :third :fourth] [0 2 4 0])))

(println "replace map to vector o numbers =>"
         (replace {2 :two 4 :four 0 :zero} [4 2 3 4 5 6 2 0]))

(println "replace map to list o numbers =>"
         (replace '{0 ZERO, 1 ONE, 2 TWO} '(This is the code 0 1 2 0)))

(println "Behaves somewhat similar to map, but notice the differences =>"
         (map [:zeroth :first :second :third :fourth] [0 2 4 0]))


