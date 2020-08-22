(ns cases.core.d.declare)

;; defs the supplied var names with no bindings, useful for making forward declarations.

(declare show)

(defn welcome [user-name] (prn (show) user-name))

(defn show [] (prn "welcome "))

(welcome "lu4nx")
