(ns cases.core.s.some->)

(prn (some-> {:a 1}
             :b
             inc))
(prn (some-> {:b 1}
             :b
             inc))

(prn (some-> {:y 3 :x 5}
             :y
             (- 2)))
(prn (some-> {:y 3 :x 5}
             :z
             (- 2)))