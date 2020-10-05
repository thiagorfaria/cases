(ns cases.core.s.some->>)

(prn (some->> {:y 3 :x 5}
              :y
              (- 2)))

(prn (some->> {:y 3 :x 5}
              :z
              (- 2)))