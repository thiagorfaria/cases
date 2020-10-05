(ns cases.core.d.doseq)

;; Repeatedly executes body (presumably for side-effects) with
;; bindings and filtering as provided by "for".  Does not retain
;; the head of the sequence. Returns nil

(doseq [x [-1 0 1]
        y [1 2 3]]
  (println (* x y)))

(let [my-map (map list [1 2 3] [6 5 4])]
  (println my-map)
  (doseq [[x y] my-map] (println (* x y))))


(doseq [year (range 2009 2021)]
  (print (str year "->")))

(println)
(doseq [text ["a" "b" "c" "d"]]
  (print (str text "->")))

(println)
(doseq [my-map {:a 1 :b 2 :c 3 :d {:e 4}}]
  (print (str (key my-map) ":" (val my-map) "->")))