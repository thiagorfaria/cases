(ns cases.core.b.butlast-test
  (:require [clojure.test :refer :all]
            [cases.core.b.butlast :as core.butlast]))

(deftest butlast-test
  (is (= (core.butlast/my-butlast [1 2 3]) [1 2])))