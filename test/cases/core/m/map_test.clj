(ns cases.core.m.map-test
  (:require [clojure.test :refer :all]
            [cases.core.m.map :refer :all]))

(deftest map-test
  (testing "should inc value from a map"
    (is (= map-inc [2 3 4 5 6])))

  (testing "should inc value from a map with partial function"
    (is (= my-map-inc [2 3 4 5 6])))

  (testing "should sum two collections by position"
    (is (= map-sum-multi-collections [5 7 9])))

  (testing "should sum map with lazy iterate"
    (is (= map-sum-lazy-iterate [2 4 6])))

  (testing "should create a list with Hello + Name"
    (is (= map-anonymous-fn '("Hello Ford!" "Hello Arthur!" "Hello Tricia!"))))

  (testing "should get value from a map "
    (is (= map-get-values '("three" "two" nil)))))
