(ns cases.s.sort-map)

;; keyval => key val
;; Returns a new sorted map with supplied mappings.  If any keys are
;; equal, they are handled as if by repeated uses of assoc.
(println (sorted-map :z 0, :a 28, :b 35))
(println (into (sorted-map) {:a 2 :b 1}))

;; (sorted-map ...) is equivalent in behavior to (sorted-map-by compare ...)
;; where compare is Clojure's default comparator function clojure.core/compare
;; See the documentation of compare for more details on its behavior.

;; For a map sorted by values, see the priority-map data structure:
;; https://github.com/clojure/data.priority-map

;; For a map sorted by the order that key/value pairs were added,
;; see ordered-map: https://github.com/clj-commons/ordered

;; Another sorted map variant is the ordering-map:
;; https://github.com/clj-commons/useful/blob/master/src/flatland/useful/map.clj#L243-L245

;; If you deal with many large maps where the keys are all integers, and
;; want a faster data structure for those, see int-map:
;; https://github.com/clojure/data.int-map

