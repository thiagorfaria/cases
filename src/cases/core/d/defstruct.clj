(ns cases.core.d.defstruct)

;; Same as (def name (create-struct keys...))

(defstruct person :name :age :height)

(println (struct person "george" 22 115))
