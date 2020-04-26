(ns cases.core.f.fn)


;; params => positional-params* , or positional-params* & next-param
;; positional-param => binding-form
;; next-param => binding-form
;; name => symbol
;;
;; Defines a function

(println (map (fn [x] (* x x)) (range 1 10)))
;; Adding a name to anonymous function, this is useful in stack trace
(println ((fn add [a b] (+ a b)) 1 2))

(println ((fn [m [k v]] (assoc m v k)) {} [:b 2]))
(println (reduce (fn [m [k v]] (assoc m v k)) {} {:b 2 :a 1 :c 3}))

(reduce prn {:b "2" :a {:aa "1"}})
(println (reduce str {:b "2" :a "1"}))


((fn [& nums] (println nums)) 1 2 3 4)
(println (apply + (list 1 2 3 4)))
(println ((fn [& nums] (/ (apply + nums) (count nums))) 1 2 3 4))
(println ((fn [int & nums] (+ int (/ (apply + nums) (count nums)))) 10 1 2 3 4))

(println ((fn [a b c] (+ a b c)) 2 4 6))
;; the equivalent of
(println (#(+ %1 %2 %3) 2 4 6))
