(ns cases.s.struct)

;Returns a new structmap instance with the keys of the
;structure-basis. vals must be supplied for basis keys in order -
;where values are not supplied they will default to nil.

(defstruct mystruct :foo :bar)

(println (struct mystruct "eggplant" "pizza"))

