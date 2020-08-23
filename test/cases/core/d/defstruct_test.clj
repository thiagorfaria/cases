(ns cases.core.d.defstruct-test
  (:require [clojure.test :refer :all]
            [cases.core.d.defstruct :refer :all]))

(def ^:private person-result {:name "george", :age 22, :height 115})

(deftest defstruct-test
  (is (= person-struct) person-result))