(ns cases.core.t.throw)

;; The expr is evaluated and thrown, therefore it should yield an instance of
;; some derive of Throwable. Please see http://clojure.org/special_forms#throw
(try
  (throw (Exception. "my exception message"))
  (catch Exception e (prn (str "caught exception: " (ex-message e)))))

(try
  (throw (Exception. "my exception message"))
  (catch Exception e (prn (str "caught exception: " (.getMessage e)))))