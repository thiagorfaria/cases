(ns cases.core.i.int-array-test
  (:require [clojure.test :refer :all]
            [cases.core.i.int-array :refer :all]))

(def ^:private my-array-result [1 2 3])
(def ^:private int-array-const-result [1 1 1 1 1])
(def ^:private int-array-const-default-result [0 0 0 0 0])
(def ^:private int-array-range-result [0 1 2 3 4])

(deftest int-array-test
  (testing "should create int array with defined values"
    (is (= (vec my-array) my-array-result)))

  (testing "should create int array with cost value")
      (is (= (vec int-array-const) int-array-const-result))

  (testing "should create const int array with default value (zero)"
    (is (= (vec int-array-const-default) int-array-const-default-result)))

  (testing "should create int array combined with range function"
    (is (= (vec int-array-range) int-array-range-result))))