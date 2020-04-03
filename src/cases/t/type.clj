(ns cases.t.type
  (:import [clojure.lang Symbol]))

; Returns the :type metadata of x, or its Class if none
;; Checking numbers
(println (type 10))
(println (type 10.0))
(println (type nil))
;; Checking collections
(println (type [10 20]))
(println (type '(10 20)))
(println (type "A string"))
(println (type :a))
(println (type Thread))
;; Checking a symbol
(println (type 'whatever))
;; A surprise attack yields
(println (type Symbol))
;; Checking a function
(defn foo [] ("any string"))
(println (type foo))