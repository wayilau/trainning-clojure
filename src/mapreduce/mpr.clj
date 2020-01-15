(ns mapreduce.mpr
  (:require [clojure.core.async :as async]))

(def test-chan (async/chan 10))

(defn test
  "this is a test function"
  []
  async/>!! test-chan "Hello, chan.")


(defn -main
  [& args]
  (async/alt! [test-chan]
              println ))

