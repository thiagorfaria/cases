(ns cases.core.i.interpose
  (:use [clojure.string :only (join)]))

;; Returns a lazy seq of the elements of coll separated by sep.
;; Returns a stateful transducer when no collection is provided.

(def my-strings ["one" "two" "three"])

(prn (interpose ", " my-strings))
(prn (apply str (interpose ", " my-strings)))
(prn (join ", " my-strings))