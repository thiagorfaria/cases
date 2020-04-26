(ns cases.core.r.recur)

;; Evaluates the exprs in order, then, in parallel, rebinds the bindings of
;; the recursion point to the values of the exprs. See
;; http://clojure.org/special_forms for more information.

(def factorial
  (fn [n]
    (loop [cnt n acc 1]
      (if (zero? cnt) acc (recur (dec cnt) (* acc cnt))))))
(prn (factorial 7))
;;
(loop [i 0]
  (when (< i 5)
    (println "1: " i)
    (recur (inc i))))
;;
(prn)
(loop [i 0]
  (if (< i 5)
    (do
      (println "2: " i)
      (recur (inc i)))))
;;
(prn)
(prn (loop [sum 0 cnt 10]
       (if (= cnt 0)
         sum
         (let [total (+ cnt sum)
               cnt-dec (dec cnt)]
           (prn (str cnt " = " total))
           (recur total cnt-dec)))))
(prn (+ 10 9 8 7 6 5 4 3 2 1))l