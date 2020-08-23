(ns cases.core.i.into-array
  (:require [cases.aux.title :refer :all])
  (:import [java.nio.file Paths]))

;Returns an array with components set to the values in aseq. The array's
;component type is type if provided, or the type of the first value in
;aseq if present, or Object. All values in aseq must be compatible with
;the component type. Class objects for the primitive types can be obtained
;using, e.g., Integer/TYPE.

;; Array's component type is set to (class 2), cannot add Strings.
;; This will result in an IllegalArgumentException
;; (println (into-array [2 "4" "8" 5]))

;; see
;;   cases.core.m.map
;;   cases.core.r.range
;;   cases.core.v.vec

(title "However, if the common type is specified, aforementioned values can be put into an array")
(def into-array-mix-type (vec (into-array Object [2 "4" "8" :a])))
(prn (vec into-array-mix-type))

(def into-array-combined-range (into-array (range 4)))
(prn (vec into-array-combined-range))

(title "if you assign a type, you still have to coerce values")
(def into-array-assigned-type (into-array Byte/TYPE (range 5)))
(prn (vec into-array-assigned-type))

(title "Evaluation aborted.")
(def into-array-eval-aborted (into-array Byte/TYPE (map byte (range 4))))
(prn (vec into-array-eval-aborted))

(title "Creating an empty array defaults to Object[]")
(def into-array-empty (into-array []))
(prn (vec into-array-empty))

(title "However, the type of an empty array can be coerced")
(def into-array-path-str (into-array ["username" "dev" "clojure"]))
(prn (Paths/get "/Users" into-array-path-str))

