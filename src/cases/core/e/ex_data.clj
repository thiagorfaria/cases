(ns cases.core.e.ex-data)

;; Returns exception data (a map) if ex is an IExceptionInfo.
;; Otherwise returns nil.
(try
  (throw (ex-info "Error" {:bad "So bad."}))
  (catch Exception e
    (prn "This is the error" (ex-data e))))