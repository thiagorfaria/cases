(ns cases.core.v.val
  (:import (clojure.lang MapEntry)))

;; Returns the value in the map entry.
(println (map val {:a 1 :b 2}))
(println (val (first {:one :two})))
(println (val (MapEntry. :a :b)))
