(ns cases.core.v.var)

;; The symbol must resolve to a var, and the Var object itself (not its value)
;; is returned. The reader macro #'x expands to (var x). See
;; http://clojure.org/special_forms for more information.

(println meta)
(println (var meta))
(println #'meta)

(println (meta (var meta)))

(println *clojure-version*)
(println (var defn))
(println (var defn 1 2 3 4))

(def a 1)
(def b (var a))
(println (alter-var-root (var a) inc))
(println (alter-var-root b inc))
(println (deref b))