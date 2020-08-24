(ns cases.core.a.aget-test
  (:require [clojure.test :refer :all]
            [cases.core.a.aget :refer :all]))

(deftest aget-test
  (testing "should aget third element"
    (is (= aget-list-double 3.0)))

  (testing "should aget 4th element"
    (is (= aget-list-int 6)))

  (testing "should try aget third element when doesn't exist return 0"
    (is (= aget-array-2s 0))))