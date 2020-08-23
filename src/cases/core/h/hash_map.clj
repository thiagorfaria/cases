(ns cases.core.h.hash-map)

;; keyval => key val
;; Returns a new hash map with supplied mappings.  If any keys are
;; equal, they are handled as if by repeated uses of assoc.

(prn (hash-map))
(prn (hash-map :key1 1 :key2 2))
(prn (hash-map :key1 1 :key1 2))
(prn (hash-map :key1 'val1 'key2 :val2 [:compound :key] nil))

(prn (map str (seq "abcdefgh")))
(prn (map #(hash-map (keyword (str %)) 0) (seq "abcdefgh")))