(ns reftest.ref-test)

(def alice-height (ref 3))

(def right-hand-bites (ref 10))

(defn eat-from-right-hand []
  (when (pos? @right-hand-bites)
    (alter right-hand-bites dec)
    (alter alice-height #(+ % 24))))