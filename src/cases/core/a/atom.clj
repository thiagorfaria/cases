(ns cases.core.a.atom)


;; Creates and returns an Atom with an initial value of x and zero or
;; more options (in any order):
;;
;; :meta metadata-map
;;
;; :validator validate-fn
;;
;; If metadata-map is supplied, it will become the metadata on the
;; atom. validate-fn must be nil or a side-effect-free fn of one
;; argument, which will be passed the intended new state on any state
;; change. If the new state is unacceptable, the validate-fn should
;; return false or throw an exception.

(def my-atom (atom 0))
(println my-atom)
(println (swap! my-atom inc))
(println my-atom)
(println (swap! my-atom (fn [n] (* (+ n n) 2))))
(println my-atom)
(println (reset! my-atom 0))
(println my-atom)

(println)
(println "Example2")
(def my-atom2 (atom 0 :validator even?))
(println my-atom2)
(try
  (swap! my-atom2 inc)
  (catch Exception e (println (ex-message e))))
(println (swap! my-atom2 (partial + 2)))
(println my-atom2)
(try
  (swap! my-atom2 (partial + 1))
  (catch Exception e (println (ex-message e))))

(println)
(println "Example3")
(def car (atom {:make "Audi" :model "Q3"}))
(prn @car)
(swap! car assoc :model "Q5")
(prn @car)
(reset! car {:make "" :model ""})
(prn @car)
