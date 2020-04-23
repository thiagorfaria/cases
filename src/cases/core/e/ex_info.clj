(ns cases.core.e.ex-info
  (:import (clojure.lang ExceptionInfo)))

;;Create an instance of ExceptionInfo, a RuntimeException subclass
;;
;; that carries a map of additional data.

(try
  (throw
    (ex-info "The ice cream has melted!"
             {:causes              #{:fridge-door-open :dangerously-high-temperature}
              :current-temperature {:value 25 :unit :celsius}}))
  (catch Exception e (prn (ex-data e))))

(try
  (throw (ex-info "bad" {:a 1 :b 2}))
  (catch ExceptionInfo e
    (prn "caught" (ex-data e))))

(defn exception-wrapper
  "Wrap exceptions to embed `:event` information from the `request` such
  that we preserve the `Caused by` convention."
  [request exception]
  (let [event (:event request)
        exc (ex-info (.getMessage ^Throwable exception)
                     {:event event}
                     exception)]
    (throw exc)))

(try
  (exception-wrapper {:event "some-event-info"}
                     (ex-info "Dang." {:trilobites :everywhere}))
  (catch Exception e (prn (ex-cause e))))