(ns applied.ch01.recipe-test
  (:require [clojure.test :refer :all]
            [applied.ch01.recipe :as ch01.recipe]))

(def ^:private toast-return
  (ch01.recipe/->Recipe
   "Toast"
   (ch01.recipe/->Person "Alex" "Miller")
   "Crispy bread"
   ["Slice of bread"]
   ["Toast bread in toaster"]
   1))

(deftest toast
  (is (= ch01.recipe/toast toast-return)))
