(ns cases.core.z.zipmap)

;; Returns a map with the keys mapped to the corresponding vals.

(prn (zipmap [:a :b :c :d :e] [1 2 3 4 5]))
(prn (zipmap [:a :b :c] [1 2 3 4]))
(prn (zipmap [:a :b :c] [1 2]))

(prn (zipmap [:a :b :c] (repeat 0)))

(prn (zipmap [:html :body :div] (repeat {:margin 0 :padding 0})))
