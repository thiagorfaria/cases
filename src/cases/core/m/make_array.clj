(ns cases.core.m.make-array
  (:use clojure.pprint))

;; Creates and returns an array of instances of the specified class of
;; the specified dimension(s).  Note that a class object is required.
;; Class objects can be obtained by using their imported or
;; fully-qualified name.  Class objects for the primitive types can be
;; obtained using, e.g., Integer/TYPE.

(pprint (make-array Integer/TYPE 3))

; Types are defined in clojure/genclass.clj:
;    Boolean/TYPE
;    Character/TYPE
;    Byte/TYPE
;    Short/TYPE
;    Integer/TYPE
;    Long/TYPE
;    Float/TYPE
;    Double/TYPE
;    Void/TYPE

(pprint (make-array Double/TYPE 3))
(pprint (make-array Integer/TYPE 2 3))
(pprint (make-array Integer/TYPE 2 3 2))

;; Create an array of Threads, then show content and type
(def ar (make-array Thread 3))
(pprint ar)
(println (type ar))