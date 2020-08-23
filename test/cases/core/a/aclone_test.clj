(ns cases.core.a.aclone-test
  (:require [clojure.test :refer :all]
            [cases.core.a.aclone :refer :all]))

(deftest aclone-test
  (is (= (vec a) (vec b))))