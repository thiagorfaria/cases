(ns cases.core.d.defprotocol)

;; A protocol is a named set of named methods and their signatures:
;; (defprotocol AProtocolName
;;
;;   ;optional doc string
;;   \"A doc string for AProtocol abstraction \"
;;
;;   ;options
;;   :extend-via-metadata true
;;
;;   ;method signatures
;;   (bar [this a b] \"bar docs \")
;;   (baz [this a] [this a b] [this a b c] \"baz docs \"))
;;
;; No implementations are provided. Docs can be specified for the
;; protocol overall and for each method. The above yields a set of
;; polymorphic functions and a protocol object. All are
;; namespace-qualified by the ns enclosing the definition The resulting
;; functions dispatch on the type of their first argument, which is
;; required and corresponds to the implicit target object ('this' in
;;                                                         Java parlance) . defprotocol is dynamic, has no special compile-time
;; effect, and defines no new types or classes. Implementations of
;; the protocol methods can be provided using extend.
;;
;; When :extend-via-metadata is true, values can extend protocols by
;; adding metadata where keys are fully-qualified protocol function
;; symbols and values are function implementations. Protocol
;; implementations are checked first for direct definitions (defrecord,
;;                                                            deftype, reify), then metadata definitions, then external
;; extensions (extend, extend-type, extend-protocol)
;;
;; defprotocol will automatically generate a corresponding interface,
;; with the same name as the protocol, i.e. given a protocol:
;; my.ns/Protocol, an interface: my.ns.Protocol. The interface will
;; have methods corresponding to the protocol functions, and the
;; protocol will automatically work with instances of the interface.
;;
;; Note that you should not use this interface with deftype or
;; reify, as they support the protocol directly:
;;
;; (defprotocol P
;;   (foo [this])
;;   (bar-me [this] [this y]))
;;
;; (deftype Foo [a b c]
;;   P
;;   (foo [this] a)
;;   (bar-me [this] b)
;;   (bar-me [this y] (+ c y)))
;;
;; (bar-me (Foo. 1 2 3) 42)
;; => 45
;;
;; (foo
;;  (let [x 42]
;;    (reify P
;;      (foo [this] 17)
;;      (bar-me [this] x)
;;      (bar-me [this y] x))))
;; => 17

(defprotocol Fly
  "A simple protocol for flying"
  (fly [this] "Method to fly"))

(defrecord Bird [name species]
  Fly
  (fly [this] (str (:name this) " flies...")))

(prn "(extends? Fly Bird)" (extends? Fly Bird))
(def crow (Bird. "Crow" "Corvus corax"))
(prn (fly crow))