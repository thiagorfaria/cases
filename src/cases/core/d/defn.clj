(ns cases.core.d.defn)

;; Same as (def name (fn [params* ] exprs*)) or (def
;;   name (fn ([params* ] exprs*)+)) with any doc-string or attrs added
;;   to the var metadata. prepost-map defines a map with optional keys
;;   :pre and :post that contain collections of pre or post conditions."

(defn foo "Foo is a simple function" [a b c] (* a b c))
(prn "foo" (foo 1 2 3))

(prn)
(defn bar [a b & [c]]
  (if c
    (* a b c)
    (* a b 100)))
(prn "bar" (bar 1 2))
(prn "bar" (bar 1 2 3))

(prn)
(defn baz [a b & {:keys [c d] :or {c 10 d 20}}]
  (* a b c d))
(prn "baz" (baz 1 2))
(prn "baz" (baz 1 2 :c 3))
(prn "baz" (baz 1 2 :c 3 :d 4))
(prn "baz" (baz 1 2 :d 4))

(prn)
(defn boo [a b & {:keys [c d] :or {c 10 d 20} :as all-specified}]
  (prn "all-specified" all-specified)
  (* a b c d))
(prn "boo" (boo 2 3))
(prn "boo" (boo 2 3 :c 4))
(prn "boo" (boo 2 3 :c 4 :d 5))
(prn "boo" (boo 2 3 :d 5))
(prn "boo" (boo 2 3 :d 5 :e 4 1 2))

(prn)
(defn bat
  ([a b]   (bat a b 100))
  ([a b c] (* a b c)))
(prn "bat" (bat 1 2))
(prn "bat" (bat 1 2 3))


(prn)
(defn trf-print [str] (prn "trf" str))
(defn trf [a b & c]
  (prn "trf" a)
  (prn "trf" b)
  (run! trf-print c))
(trf 1 2)
(trf 1 2 3 4 5)


;; prepost-map examples
(prn)
(defn example
  [{:keys [a b]}]
  {:pre [(not (and a b))
         (or a b)]}
  (prn "example" a b))

; assert error (example {:a 1 :b 2})
; assert error (example {:c 1 :d 2})
(example {:a 1 :c 2})

;; check that the error-free average is between the max and min of the arguments:
(defn avg
  [error & nums]
  {:post [(<= (apply min nums) % (apply max nums))]}
  (/ (apply + error nums)
     (count nums)))

(prn "avg" (avg 0 1 2 3 4 5))
; assert error -> (avg 100 1 2 3 4 5)