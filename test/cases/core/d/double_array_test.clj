(ns cases.core.d.double-array-test
  (:require [clojure.test :refer :all]
            [cases.core.d.double-array :refer :all]))

(deftest double-array-test
  (testing "should test double-array"
    (is (= (vec ds) [3.0 6.0 9.0 12.0 15.0 18.0 21.0 24.0 27.0])))

  (testing "should test double-array after use arrays functions"
    (is (= (vec ds2) [3.0 6.0 9.0 27.0 99.0 99.0 99.0 99.0 99.0]))))