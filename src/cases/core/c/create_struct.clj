(ns cases.core.c.create-struct)

;; Returns a structure basis object.

;; Creates a person structure
(def person (create-struct :name :age))

;; Creates a structure with the given values associated with the structure keys
(println (struct person "Brad Cypert" 23))

