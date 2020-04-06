(ns cases.c.catch)

(try
  (/ 1 0)
  (catch Exception e
    (println e)
    (println (.getMessage e))))