(ns cases.core.s.swap!)

;; Atomically swaps the value of atom to be:
;; (apply f current-value-of-atom args). Note that f may be called
;; multiple times, and thus should be free of side effects.  Returns
;; the value that was swapped in.

(def players (atom ()))
(println players)
(println (swap! players conj :player1))
(println (swap! players conj :player2))
(println (deref players))
(println players)
(println @players)

(println)
(println "Example 2")
(def counter (atom 0))
(println (swap! counter inc))
(println (swap! counter inc))

(println)
(println "Example 3")
(def m1 (atom {:a "A" :b "B" :n 0}))
(println @m1)
(println (swap! m1 update-in [:n] inc))
