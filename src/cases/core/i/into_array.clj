(ns cases.core.i.into-array
  (:import [java.nio.file Paths]))

;Returns an array with components set to the values in aseq. The array's
;component type is type if provided, or the type of the first value in
;aseq if present, or Object. All values in aseq must be compatible with
;the component type. Class objects for the primitive types can be obtained
;using, e.g., Integer/TYPE.

;; Array's component type is set to (class 2), cannot add Strings.
;; This will result in an IllegalArgumentException
;; (println (into-array [2 "4" "8" 5]))

;; However, if the common type is specified, aforementioned values can be put into an array
(println (vec (into-array Object [2 "4" "8" 5])))

(println (vec (into-array (range 4))))

;; if you assign a type, you still have to coerce values
(println (vec (into-array Byte/TYPE (range 5))))

;; Evaluation aborted.
(println (vec (into-array Byte/TYPE (map byte (range 4)))))

;; Creating an empty array defaults to Object[]
(println (vec (into-array [])))

;; However, the type of an empty array can be coerced
(println (Paths/get "/Users" (into-array ["username" "dev" "clojure"])))

