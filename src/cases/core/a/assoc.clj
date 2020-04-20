(ns cases.core.a.assoc)

;; assoc[iate]. When applied to a map, returns a new map of the
;; same (hashed/sorted) type, that contains the mapping of key(s) to
;; val(s). When applied to a vector, returns a new vector that
;; contains val at index. Note - index must be <= (count vector).
(println (pr-str (assoc {} :key1 "value" :key2 "another value")))
(println (pr-str (assoc {:key1 "old value1" :key2 "value2"} :key1 "value1" :key3 "value3")))
(println (pr-str (assoc [1 2 3] 0 10)))
(println (pr-str (assoc [1 2 3] 2 '(4 6))))
(println (pr-str (assoc [1 2 3] 3 10)))

(try
  (assoc [1 2 3] 4 10)
  (catch Exception e
    (println "java.lang.IndexOutOfBoundsException")))
