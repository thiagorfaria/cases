(ns cases.core.a.apply)

;; Applies fn f to the argument list formed by prepending intervening arguments to args.

(def ^:dynamic *strings* ["str1" "str2" "str3"])
(prn *strings*)
(println (str *strings*))

(prn (apply str *strings*))


;; Note the equivalence of the following two forms
(prn (apply str ["str1" "str2" "str3"]))                    ;;=> "str1str2str3"
(prn (str "str1" "str2" "str3"))                            ;;=> "str1str2str3"


;; If you were to try
(println (max [1 2 3]))

;; You would get '[1 2 3]' for the result. In this case, 'max' has received one
;; vector argument, and the largest of its arguments is that single vector.

;; If you would like to find the largest item **within** the vector, you would need
;; to use `apply`
(println (apply max [1 2 3]))

;; which is the same as
(println (max 1 2 3))


;; 'apply' is used to apply an operator to its operands.
(println (apply + '(1 2 3 5 7)))

;; You can also put operands before the list of
;; operands and they'll be consumed in the list of operands

(println (apply + 1 2 '(3 4)))

