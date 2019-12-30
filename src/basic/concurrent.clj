(ns basic.concurrent
  (:import (java.util.concurrent Executors)))

(defn test-stm [nitems nthreads niters]
  (let [refs (map ref (repeat nitmes 0))
        pool (Executors/newFixedThreadPool nthreads)
        tasks (map (fn [t]
                     (fn []
                       (dotimes [n niters]
                         (dosync
                           (doseq [r refs]
                             (alter r + 1 t)))))))])

  )