(ns cases.core.b.bigdec-test
  (:require [clojure.test :refer :all]))

(deftest bigdec-test
  (is (= (bigdec 1.0) 1.0M))
  (is (= (bigdec 5) 5.0M))
  (is (= (bigdec -3) -3.0M))
  (is (= (bigdec "123.45") 123.45M))
  (is (= (bigdec 2/4) 0.5M)))