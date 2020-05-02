(ns cases.core.n.ns2)

;; Sets *ns* to the namespace named by name (unevaluated), creating it
;; if needed.  references can be zero or more of: (:refer-clojure ...)
;; (:require ...) (:use ...) (:import ...) (:load ...) (:gen-class)
;; with the syntax of refer-clojure/require/use/import/load/gen-class
;; respectively, except the arguments are unevaluated and need not be
;; quoted. (:gen-class ...), when supplied, defaults to :name
;; corresponding to the ns name, :main true, :impl-ns same as ns, and
;; :init-impl-ns true. All options of gen-class are
;; supported. The :gen-class directive is ignored when not
;; compiling. If :gen-class is not supplied, when compiled only an
;; nsname__init.class will be generated. If :refer-clojure is not used, a
;; default (refer 'clojure.core) is used.  Use of ns is preferred to
;; individual calls to in-ns/require/use/import:
;;
;; (ns foo.bar
;;   (:refer-clojure :exclude [ancestors printf])
;;   (:require (clojure.contrib sql combinatorics))
;;   (:use (my.lib this that))
;;   (:import (java.util Date Timer Random)
;;            (java.sql Connection Statement)))

;; TODO Implement another examples
(println (create-ns 'my-new-namespace))

(println (ns my-new-namespace))

(println (require 'my-new-namespace))

(println (use 'my-new-namespace))

;; This example will illustrate changing between namespaces at the repl

(println (ns demo.namespace))
(defn foo [] (prn "Hello from demo.namespace"))
(foo)
(ns user)
;; Unable to resolve symbol: foo in this context
;; (foo)
(demo.namespace/foo)
(refer 'demo.namespace)
(foo)
