(ns cases.core.a.alength-test
  (:require [clojure.test :refer :all]
            [cases.core.a.alength :refer :all]))

(deftest alength-test
  (testing "should get a my-array length"
    (is (= my-array-length 3)))

  (testing "should get a my-array-2d length"
    (is (= my-array-2d-length 4))))