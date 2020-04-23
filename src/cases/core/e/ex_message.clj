(ns cases.core.e.ex-message)

;; Returns the message attached to ex if ex is a Throwable.

;; Otherwise returns nil.
(try
  (let [error-message "Something went wrong!"]
    (throw (ex-info error-message {:error 404})))
  (catch Exception e
    (prn (str "Oops! " (ex-message e)))
    (prn (str "Because! " (ex-data e)))))