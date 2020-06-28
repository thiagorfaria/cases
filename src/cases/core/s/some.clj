(ns cases.core.s.some)

;; Returns the first logical true value of (pred x) for any x in coll,
;; else nil.  One common idiom is to use a set as pred, for example
;; this will return :fred if :fred is in the sequence, otherwise nil:
;; (some #{:fred} coll)

(println "even? 1 2 3 4" (some even? '(1 2 3 4)))
(println "even? 1 3 5 7" (some even? '(1 3 5 7)))

(println "some [false false false]" (some true? [false false false]))
(println "some [false true false]" (some true? [false true false]))
(println "some [false false true]" (some true? [false false true]))
(println "some [true false true]" (some true? [true true true]))

(println "some 1 2 3 4 5 equals 5" (some (fn [n] (= 5 n)) [1 2 3 4 5]))
(println "some 1 2 3 4 5 equals 5" (some #(= 5 %) [1 2 3 4 5]))
(println "some 6 7 8 9 10 equals 5" (some (fn [n] (= 5 n)) [6 7 8 9 10]))

;; the first logical true value is returned, i.e. anything but nil and false
;; when return nil if its predicate is logical false.
(println (some (fn [n] (when (even? n) n)) '(1 2 3 4)))
(println (some #(when (even? %) %) '(1 2 3 4)))
(println (some #(when (even? %) %) '(1 3 5 7)))

(prn "some 2 in {2 \"two\" 3 \"three\"}" (some {2 "two" 3 "three" 1 "one" nil "nil"} [nil 3 2 1]))
(prn "some 3 in {2 \"two\" 3 \"three\"}" (some {2 "two" 3 "three"} [nil 2 3]))
(println "some nil in {nil \"nothing\" 2 \"two\" 3 \"three\"}" (some {nil "nothing" 2 "two" 3 "three"} [nil 3 2]))

;; the hash (as function) returns a nil for the key of '3',
;; therefore 'some' keeps inspecting the collection,
;; returning the next logical true value.
(println (some {2 "two" 3 nil} [nil 3 2]))

(println (first (filter even? [1 2 3 4])))
(println (some (fn [n] (when (even? n) n)) [1 2 3 4]))
(println (some #(if (even? %) %) [1 2 3 4]))

(def word "foo")
(def words ["bar" "baz" "foo" ""])
(println (some (partial = word) words))

(println (some #{2} (range 0 10)))
(println (some #{6 2 4} (range 0 10)))
(println (some #{2 4 6} (range 3 10)))
(println (some #{200} (range 0 10)))

(prn)
(println ((fn [f] (f 3 7)) str))
(println
      (list (#(% 3 7) +)
            (#(% 3 7) -)
            (#(% 3 7) *)
            (#(% 3 7) /)
            (#(% 3 7) >)
            (#(% 3 7) <)
            (#(% 3 7) =)
            (#(% 3 7) str)))
(println (map #(% 3 7) (list + - * / > < = str)))

(defn ne [n1 n2] (not= n1 n2))
(println (some #(% 3 7) (list ne)))
(println (some #(% 3 3) (list ne)))
(println (ne 3 3))
