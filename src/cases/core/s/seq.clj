(ns cases.core.s.seq)

;; Returns a seq on the collection. If the collection is
;; empty, returns nil.  (seq nil) returns nil. seq also works on
;; Strings, native Java arrays (of reference types) and any objects
;; that implement Iterable. Note that seqs cache values, thus seq
;; should not be used on any Iterable whose iterator repeatedly
;; returns the same mutable object.

(prn (seq '(1)))
(prn (seq [1 2]))
(prn (seq "abc"))

;; Corner cases
(prn (seq nil))
(prn (seq '()))
(prn (seq []))
(prn (seq ""))
