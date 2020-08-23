(ns cases.core.s.struct)

;Returns a new structmap instance with the keys of the
;structure-basis. vals must be supplied for basis keys in order -
;where values are not supplied they will default to nil.

;; see
;;   cases.core.d.defstruct

(defstruct mystruct :foo :bar)

(def mystruct-struct (struct mystruct "eggplant" "pizza"))
(prn mystruct-struct)

