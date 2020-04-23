(ns cases.core.p.prn)

;; Same as pr followed by (newline). Observes *flush-on-newline*
(prn "fred" 1)
(def items [ "hello \"" :a 1 (list :b 2) \c {:d 4} #{5 6 7} ])
(prn items)
(println items)
(println (pr-str items))