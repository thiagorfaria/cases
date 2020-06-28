(ns getting.chapter14.test-test
  (:require [clojure.test :refer :all]
            [clojure.test.check :as check]
            [clojure.test.check.properties :as check.properties]
            [clojure.test.check.clojure-test :as check.clojure-test]
            [getting.chapter14.test :as ch14.test]))

(prn "Spotting Bugs with clojure.test")
(def books
  [{:title "2001" :author "Clarke" :copies 21}
   {:title "Emma" :author "Austen" :copies 10}
   {:title "Misery" :author "King" :copies 10}])

(deftest find-by-title-test
  (testing "Finding books"
    (is (not (nil? (ch14.test/find-by-title "Emma" books))))
    (is (not (ch14.test/find-by-title "Some other book" books))))
  (testing "Copies in inventory"
    (is (= 10 (ch14.test/number-of-copies-of "Emma" books)))))

(prn)
(prn "Checking Properties")
(check/quick-check 50
                   (check.properties/for-all [i-and-b ch14.test/inventory-and-book-generated]
                                             (= (ch14.test/find-by-title (-> i-and-b :book :title) (:inventory i-and-b))
                                                (:book i-and-b))))

(check.clojure-test/defspec find-books-by-title-finds-books 50
                            (check.properties/for-all [i-and-b ch14.test/inventory-and-book-generated]
                                                      (= (ch14.test/find-by-title (-> i-and-b :book :title) (:inventory i-and-b))
                                                         (:book i-and-b))))