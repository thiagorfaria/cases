(ns cases.core.a.acessor-test
  (:require [cases.core.a.acessor :refer :all]
            [clojure.test :refer :all]))

(def ^:private make-car "Toyota")
(def ^:private car-result {:make make-car, :model "Prius", :year 2010, :color nil})

(deftest acessor-test
  (testing "should test car"
    (is (= car car-result)))
  (testing "should test make a car"
    (is (= (make car) make-car))))