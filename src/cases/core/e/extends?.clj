(ns cases.core.e.extends?)

;; Returns true if type extends protocol

(defprotocol Area
  (get-area [this]))

(defrecord Rectangle [width height]
  Area
  (get-area [this] (* (:width this) (:height this))))

(prn (extends? Area Rectangle))
(-> (->Rectangle 10 10) get-area prn)