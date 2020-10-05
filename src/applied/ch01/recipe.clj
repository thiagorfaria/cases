(ns applied.ch01.recipe)

(defrecord Recipe
  [name         ;; string
   author       ;; recipe creator
   description  ;; string
   ingredients  ;; list of ingredients
   steps        ;; sequence of string
   servings     ;; number of servings
   ])

(defrecord Person
  [first-name ;; first name
   last-name  ;; last name
  ])

(def toast
  (->Recipe
   "Toast"
   (->Person "Alex" "Miller")
   "Crispy bread"
   ["Slice of bread"]
   ["Toast bread in toaster"]
   1))
