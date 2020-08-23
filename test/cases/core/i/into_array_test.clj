(ns cases.core.i.into-array-test
  (:require [clojure.test :refer :all]
            [cases.core.i.into-array :refer :all]))

(def ^:private into-array-mix-type-result [2 "4" "8" :a])
(def ^:private into-array-combined-range-result [0 1 2 3])
(def ^:private into-array-assigned-type-result [0 1 2 3 4])
(def ^:private into-array-eval-aborted-result [0 1 2 3])
(def ^:private into-array-empty-result [])
(def ^:private into-array-path-str-result ["username" "dev" "clojure"])

(deftest into-array-test
  (testing "should create into array from mix type"
    (is (= (vec into-array-mix-type) into-array-mix-type-result)))

  (testing "should create into array combined to range function"
    (is (= (vec into-array-combined-range) into-array-combined-range-result)))

  (testing "should create into array with assigned type"
    (is (= (vec into-array-assigned-type) into-array-assigned-type-result)))

  (testing "should create into array from evaluating aborted"
    (is (= (vec into-array-eval-aborted) into-array-eval-aborted-result)))

  (testing "should create into array from mix type"
    (is (= (vec into-array-empty) into-array-empty-result)))

  (testing "should create into array from string path"
    (is (= (vec into-array-path-str) into-array-path-str-result))))
