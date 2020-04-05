(ns cases.n.new
  (:import [java.util ArrayList]))

;; Instantiate a class. See http://clojure.org/java_interop#new for
;more information.

;; Create a Java ArrayList using the 0 argument constructor
(def a  (new ArrayList))
(.add a "aaa")
(.add a "bbb")
(println (pr-str a))