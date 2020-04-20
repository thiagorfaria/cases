(ns cases.core.v.vals
  (:require [clojure.set :as set]))

;; Returns a sequence of the map's values, in the same order as (seq map).
(println (pr-str (vals {:a "foo", :b "bar"})))
(println (vals {}))
(println (vals nil))

(defn flatten-a-map [maps]
  (apply set/union (vals maps)))
(println (flatten-a-map {:e #{:m :f}, :c #{:f}, :b #{:c :f}, :d #{:m :f}, :a #{:c :f}}))
