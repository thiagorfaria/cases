(ns getting.chapter09.pricing)

(def discount-rate 0.15)

(defn discount-price [book]
  (let [price (:price book)
        discount (* discount-rate price)]
    (- price discount)))