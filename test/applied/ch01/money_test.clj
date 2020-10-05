(ns applied.ch01.money-test
  (:require [clojure.test :refer :all]
            [applied.ch01.money :as money]))

;; Subs
(def ^:private currencies money/currencies)
(def ^:private usd1 (money/->Money 10 (:usd currencies)))
(def ^:private usd2 (money/->Money 10 (:usd currencies)))
(def ^:private usd3 (money/->Money 10 (:usd currencies)))
(def ^:private usd4 (money/->Money 20 (:usd currencies)))
(def ^:private usd5 (money/->Money 30 (:usd currencies)))

(deftest money
  (testing "should check monies are equals"
    (is (= (money/=$ usd1) true))
    (is (= (money/=$ usd1 usd2) true))
    (is (= (money/=$ usd1 usd2 usd3) true))
    (is (= (money/=$ usd1 usd2 usd3 usd1) true))
    (is (= (money/=$ usd1 usd4) false))
    (is (= (money/=$ usd1 usd2 usd4) false)))

  (testing "should sum monies"
    (is (= (money/+$ usd1) usd1))
    (is (= (money/+$ usd1 usd2) usd4))
    (is (= (money/+$ usd1 usd2 usd3) usd5)))

  (testing "should multiply monies"
    (is (= (money/*$ usd1 2) usd4))))

