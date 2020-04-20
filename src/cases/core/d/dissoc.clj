(ns cases.core.d.dissoc)

;; dissoc[iate]. Returns a new map of the same (hashed/sorted) type,
;; that does not contain a mapping for key(s).

(println (dissoc {:a 1 :b 2 :c 3}))
(println (dissoc {:a 1 :b 2 :c 3} :b))
(println (dissoc {:a 1 :b 2 :c 3} :d))
(println (dissoc {:a 1 :b 2 :c 3} :c :b))

(println (update-in {:a {:b {:x 3} :c 1}} [:a :b] dissoc :x))