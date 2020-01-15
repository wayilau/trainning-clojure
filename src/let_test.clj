(ns let-test)

(def arr [1 2 3 4 5])

(def some-one {:id 123 :name "john" :age 18 :job "enginneer" :sex "male"})

(defn lettests
  "this file is learning let.
  let is a var bind operate. the tests shows how let using in clojure."
  []
  ;顺序绑定
  (let [x 1 y 2] (println x "," y))
  ;通配符无效
  ;(let [x 1 _ 2] (println x "," y))
  ;匹配剩余
  (let [[x y & z] arr] (println x "," y "," z))
  ;匹配所有
  (let [[x y :as z] arr] println x "," y "," z)
  ;map绑定
  (let [{id :id name :name} some-one] (println id " " name))
  ;如果有 &，则 :as须放到最后
  (let [[x y &z :as all] arr] (println all))
  )

(defn -main [&  args]
  (lettests)
  )
