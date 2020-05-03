(ns cases.core.s.sort)

;; Returns a sorted sequence of the items in coll. If no comparator is
;; supplied, uses compare.  comparator must implement
;; java.util.Comparator.  Guaranteed to be stable: equal elements will
;; not be reordered.  If coll is a Java array, it will be modified.  To
;; avoid this, sort a copy of the array.

(let [my-vector [3 1 2 4]
      my-vector-sorted (sort my-vector)]
  (println "My vector type" (type my-vector))
  (println "My vector" my-vector)
  (println "My type of vector sorted" (type my-vector-sorted))
  (println "My vector" my-vector-sorted))

(println (sort > (vals {:foo 5, :bar 2 :baz 10})))


(def my-map {:b 1 :c 3 :a 2 :d 2})
(defn my-compare [a b]
  (let [last-a (last a)
        last-b (last b)
        result (compare last-a last-b)]
    (println last-a " - " last-b " - " result)
    result))

(println my-map)
(println (sort #(my-compare %1 %2) my-map))
(println (sort-by last {:b 1 :c 3 :a 2 :d 2}))

(defstruct goods :id :price)

(def data (map #(struct goods %1 %2)
               (shuffle (range 0 10)) (shuffle
                                        (into (range 100 500 100)
                                              (range 100 500 100)))))

(map prn data)

(defn comp-goods-price
  "a compare function by :price of the struct 'goods.' the sort order
   is superior to the lower price and if the price is same, it is
   superior to the lower id."
  [el1 el2]
  (if (or (< (:price el1) (:price el2))
          (and (= (:price el1) (:price el2)) (< (:id el1) (:id el2))))
    true
    false))

(prn (sort (comp comp-goods-price) data))
;; This is not sort by id too.
(prn (sort-by :price < data))
