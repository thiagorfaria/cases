(ns cases.core.m.ex-merge)

;; Returns a map that consists of the rest of the maps conj-ed onto
;; the first.  If a key occurs in more than one map, the mapping from
;; the latter (left-to-right) will be the mapping in the result.

(def map-test {:a {:aa 1 :ab 2} :b 3 :c {:ca 1 :cb 2}})
(println map-test)

(println (:a map-test))
(def map-merge-test (merge (:a map-test) {:d {:da 1 :db 2}}))
(println map-merge-test)

(println (merge {:a 1 :b 2 :c 3} {:b 9 :d 4}))

(println (merge {:a 1} nil))
(println (merge nil {:a 1}))
(println (merge nil nil))

(println (merge {:foo "foo-default" :bar "bar-default"}
                {:foo "custom-value"}))


