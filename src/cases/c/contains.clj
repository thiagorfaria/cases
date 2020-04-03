(ns cases.c.contains)

;Returns true if key is present in the given collection, otherwise
;returns false.  Note that for numerically indexed collections like
;vectors and Java arrays, this tests if the numeric key is within the
;range of indexes. 'contains?' operates constant or logarithmic time;
;it will not perform a linear search for a value.  See also 'some'.

;; `contains?` is straightforward for maps:
(println (contains? {:a 1} :a))                             ;=> true
(println (contains? {:a nil} :a))                           ;=> true
(println (contains? {:a 1} :b))                             ;=> false

;; It's likely to surprise you for other sequences because it's
;; about *indices* or *keys*, not *contents*:
(println (contains? [:a :b :c] :b))                         ;=> false
(println (contains? [:a :b :c] 2))                          ;=> true
(println (contains? "test" 0))                              ;=> true
(println (contains? "test" 3))                              ;=> true
(println (contains? "test" 6))                              ;=> false

;; Although lists are sequences, they are not keyed sequences.
;; `contains?` should not be used for lists.
;(contains? '(1 2 3) 1)

;; It also works on native arrays, HashMaps or HashSets:
(import '[java.util HashMap HashSet])
(println (contains? (doto (HashSet.) (.add 1)) 1))          ;=> true
(println (contains? (doto (HashMap.) (.put "a" 1)) "a"))    ;=> true
(println (contains? (int-array [1 2 3]) 0))                 ;=> true

;; Can be used to test set membership
(def s #{"a" "b" "c"})

;; The members of a set are the keys of those elements.
(println (contains? s "a"))                                 ;=> true
(println (contains? s "z"))                                 ;=> false


;; When "key" is a number, it is expected to be an integer.
;; Beyond that limit, lossy truncation may result in unexpected results:
(println (contains? [1 2 3] 4294967296))