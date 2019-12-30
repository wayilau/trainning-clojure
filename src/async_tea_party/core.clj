(ns async-tea-party.core
  (:require [clojure.core.async :as async]))

;无缓冲的chan
;(def tea-channel (async/chan))

;有缓冲的

(def tea-channel (async/chan 10))
(def milk-channel (async/chan 10))
(def sugar-channel (async/chan 10))

；write to channel
(async/>!! tea-channel :cup-of-tea)

;get from channel
(async/<!! tea-channel)
(async/go-loop []
  (let [[v ch] (async/alts! [tea-channel
                             milk-channel
                             sugar-channel])]
    (println "Got " v " from " ch)
    (recur)))

