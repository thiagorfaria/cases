(ns cases.core.i.instance?
  (:import [java.util ArrayList Collection RandomAccess]
           [clojure.lang IFn Keyword]))

;; Evaluates x and tests if it is an instance of the class
;; c. Returns true or false
(println "(instance? Long 1)" (instance? Long 1))
(println "(instance? Integer 1)" (instance? Integer 1))
(println "(instance? Number 1)" (instance? Number 1))
(println "(instance? String 1)" (instance? String 1))
(println "(instance? String \"1\")" (instance? String "1"))

(def al (new ArrayList))
(println "(instance? java.util.Collection al)" (instance? Collection al))
(println "(instance? java.util.RandomAccess al)" (instance? RandomAccess al))
(println "(instance? java.lang.String al)" (instance? String al))
(println "(instance? clojure.lang.IFn +)" (instance? IFn +))
(println "(instance? clojure.lang.Keyword :a)" (instance? Keyword :a))
(println "(instance? clojure.lang.IFn :a)" (instance? IFn :a))
(println "(instance? clojure.lang.IFn {:a 1})" (instance? IFn {:a 1}))