(ns cases.core.s.set!
  (:import (clojure.lang IFn)))

;; Assignment special form. When the first operand is a field member access
;; form, the assignment is to the corresponding field. If it is an instance
;; field, the instance expr will be evaluated, then the expr. In all cases
;; the value of expr is returned. Note - you cannot assign to function params
;; or local bindings. Only Java fields, Vars, Refs and Agents are mutable in
;; Clojure. See http://clojure.org/special_forms for more information.

(println *warn-on-reflection*)
(set! *warn-on-reflection* true)
(println *warn-on-reflection*)
(set! *warn-on-reflection* nil)
(println *warn-on-reflection*)

;; A mutable (and thread unsafe) Counter class.
;; set! is used to mutate the internal cnt attribute.
;; TODO see again
(deftype Counter [^:unsynchronized-mutable cnt]
  IFn
  (invoke [_] (set! cnt (inc cnt))))

(def counter (->Counter 0))
(println (counter))
(println (counter))