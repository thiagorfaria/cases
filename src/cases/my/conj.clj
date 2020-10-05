(ns cases.my.conj)

(def my-vec [1 2 3 4 5])

(defn =$
  [m1 m2 & monies] (map prn ))

(prn (=$ 6 2 my-vec))