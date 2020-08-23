(ns cases.core.d.defstruct)

;; Same as (def name (create-struct keys...))

;; see
;;   cases.core.s.struct

(defstruct person :name :age :height)

(def person-struct (struct person "george" 22 115))
(prn person-struct)
