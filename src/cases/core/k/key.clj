(ns cases.core.k.key
  (:import (clojure.lang MapEntry)))

;; Returns the key of the map entry.
(println (map key {:a 1 :b 2}))
(println (key (MapEntry. :a :b)))
