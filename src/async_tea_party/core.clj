(ns async-tea-party.core
  (:require [clojure.core.async :as async]))

;无缓冲的chan
;(def tea-channel (async/chan))

;有缓冲的

(def tea-channel (async/chan 10))

(async/>!! tea-channel :cup-of-tea)