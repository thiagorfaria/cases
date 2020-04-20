(ns cases.core.a.acessor)

;Returns a fn that, given an instance of a structmap with the basis,
;returns the value at the key.  The key must be in the basis. The
;returned function should be (slightly) more efficient than using
;get, but such use of accessors should be limited to known
;performance-critical areas.

(defstruct car-struct :make :model :year :color)

(def car (struct car-struct "Toyota" "Prius" 2010))

(def make (accessor car-struct :make))

(make car)
