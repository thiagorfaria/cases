(ns cases.core.k.keys)

;; Returns a sequence of the map's keys, in the same order as (seq map).
(println (keys {:keys :and, :some :values}))
(println (keys {}))
(println (keys nil))
