(ns cases.aux.title)

(defn- title-no-split-row [str]
  (println ";" str))

(defn title
  ([] (println "; First example"))
  ([str & strv]
   (println)
   (println ";" str)
   (if-not (empty? strv)
     (run! title-no-split-row strv))))