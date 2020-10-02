(ns applied.ch01.apollo-test
  (:require [clojure.test :refer :all]
            [applied.ch01.apollo :refer :all]))

;; Stub
(def ^:private apollo-4-mission-1-result
  {:name     "Apollo 4",
   :system   "Saturn V",
   :launched #inst"1967-11-09T12:00:01.000-00:00",
   :manned   false,
   :cm-name  nil,
   :lm-name  nil,
   :orbits   3,
   :evas     nil})

(def ^:private apollo-4-mission-2-result
  {:cm-name  nil
   :evas     0
   :launched #inst "1967-11-09T12:00:01.000-00:00"
   :lm-name  nil
   :manned   false
   :name     "Apollo 4"
   :orbits   3
   :system   "Saturn V"})

(def ^:private apollo-4-mission-4-result
  {:cm-name  ""
   :evas     0
   :launched #inst "1967-11-09T12:00:01.000-00:00"
   :lm-name  ""
   :manned   false
   :name     "Apollo 4"
   :orbits   3
   :system   "Saturn V"})

(def ^:private apollo-11-mission-3-result
  {:cm-name  "Columbia"
   :evas     1
   :launched #inst "1967-07-16T13:32:00.000-00:00"
   :lm-name  "Eagle"
   :manned   true
   :name     "Apollo 11"
   :orbits   30
   :system   "Saturn V"})

(deftest apollo-test
  (testing "should create apollo 4 mission 1"
    (is (= apollo-4-mission-1 apollo-4-mission-1-result)))

  (testing "should create apollo 4 mission 2"
    (is (= apollo-4-mission-2 apollo-4-mission-2-result)))

  (testing "should create apollo 4 mission 3"
    (is (= apollo-4-mission-3 apollo-4-mission-1-result)))

  (testing "should create apollo 4 mission 4"
    (is (= apollo-4-mission-4 apollo-4-mission-4-result)))

  (testing "should create apollo 11 mission 3"
    (is (= apollo-11-mission-3 apollo-11-mission-3-result))))

;; Stub

(def earth-result
  #applied.ch01.apollo.Planet{:name                 "Earth",
                              :moons                1,
                              :volume               1000000,
                              :mass                 1000000,
                              :aphelion             123,
                              :perihelion           123,
                              :orbital-eccentricity [:a :b :c]})

(deftest make-planet-test
  (testing "should create earth"
    (is (= earth earth-result))))
