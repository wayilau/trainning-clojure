(ns atomtest.atom-test)

(def counter (atom 0))

(let [n 5]
  (future (dotimes [_ n] (swap! counter inc)))
  (future (dotimes [_ n] (swap! counter inc)))
  (future (dotimes [_ n] (swap! counter inc))))

;;在inc之前加一个副作用的语句

(defn inc-print [val]
  (println val)
  (inc val))

(swap! counter inc-print)

(let [n 2]
  (future (dotimes [_ n] (swap! counter inc-print)))
  (future (dotimes [_ n] (swap! counter inc-print)))
  (future (dotimes [_ n] (swap! counter inc-print))))