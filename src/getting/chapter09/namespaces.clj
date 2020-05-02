(ns getting.chapter09.namespaces
  (:require [getting.chapter09.pricing :as chap09.pricing]
            [getting.chapter09.pricing :refer [discount-price]]))

;; ## A place for your vars
(println "## A place for your vars")
;; Copy and paste on repl
;; (ns pricing)

;; (def discount-rate 0.15)

;; (println discount-rate)

;; (defn discount-price [book]
;;   (* (-1.0 discount-rate) (:price book)))

;; (ns user)

;; (println (discount-price {:title "Emma" :price 9.99}))

;; (ns pricing)

;; (println (discount-price {:title "Emma" :price 9.99}))

;; ## As and Refer
(println "## As and Refer")
(require '[getting.chapter09.pricing :as ch09.price])

(println (chap09.pricing/discount-price {:title "Emma" :price 9.99}))
(println (ch09.price/discount-price {:title "Emma" :price 9.99}))

;(defn discount-price [book]
;  (:price book))

(println ch09.price/discount-rate)
(println (discount-price {:title "Emma" :price 9.99}))

;; ## Namespaces, Symbols and Keywords
(println "## Namespaces, Symbols and Keywords")
(println "Current ns:" *ns*)

(println (find-ns '+))
(println (find-ns 'cases.core.vars.+))

(println (count (ns-map (find-ns 'getting.chapter09.pricing))))

(println (namespace 'chap09.pricing/discount-price))

;(:cases.core.a.a-get/a1)
;(::author)