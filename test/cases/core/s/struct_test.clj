(ns cases.core.s.struct-test
  (:require [clojure.test :refer :all]
            [cases.core.s.struct :refer :all]))

(def ^:private mystruct-result {:foo "eggplant", :bar "pizza"})

(deftest struct-test
  (is (= mystruct-struct mystruct-result)))