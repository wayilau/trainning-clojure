(ns tests
  (:require [let-test]))

(defn -main
  "tests defn- & defn. when using a not public func,
  error ocurred. an IllegalStateException throws."
  [& args]
  (let-test/lettests))
