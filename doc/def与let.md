# def & let
- def 用来创建全局变量
- let 用来创建局部变量

(def develop "lice")

(let [develop "alice"
rabbit "White"]
[develop rabbit])

- let定义的变量在一个[]内， 使用范围在let的()内。
```$xslt

(let [x 1
y 2]
(+ x y)
```

let定义的变量只适合在局部，想要在外部使用时会出现编译错误。
```$xslt
clojure 变量绑定 可以是let绑定， 函数形参实参绑定， 分为2大类，均支持嵌套，活用let绑定会使代码简洁
1. 顺序绑定
(let [x 1 y 2] (print x, "," y))  #x=>1,  y=>2
 
(def arr [1 2 3 4 5])
(let [[x y z] arr] (print x "," y "," z))#  x=>1,  y=>2, z=>3
 
1.1 匹配剩余参数（使用&符号）
(def arr [1 2 3 4 5])
(let [[x y & z] arr] (print x "," y "," z))#  x=>1,  y=>2, z=>[3 4 5]
 
1.2 匹配整个列表（使用 :as)
(def arr [1 2 3 4 5])
(let [[x y :as z] arr] (print x "," y "," z))#  x=>1,  y=>2, z=>[1 2 3 4 5]
 
如果带有 &，则 :as须放到最后
(def arr [1 2 3 4 5])
(let [[x y & z :as all] arr] (print z) (print "\n") (print all))
 
2. map 绑定
此种绑定会将变量视为map
以下let绑定中的变量是个map结构
(def some-one {:id 123 :name "john" :age 18 :job "enginneer" :sex "male" })
(let [{id :id name :name} some-one] (print id " " name)) #id=> 123,   name=> john
 
以下是个vector，但会被视为map
(let [{a 0 b 2} [3 4 5 6 7 8]] (print x y)) # a=>3, b=>5
 
:as 也可用于map绑定 语义和顺序绑定一样
:or 用于提供默认值，当绑定的key不在变量map中时，就会提供默认值
以下例子 :unknown 是个不存在的key，所以使用:or提供的默认值
(let [{x :a y :b z :unknown :or {z 11}} {:a 5 :b 6}] (println x) (println y) (println z))
 
关于 :keys,  :str,  :sys
这三个用于绑定时，指定key类型为相应的类型，且绑定方式变得
简洁了以下使用:key的例子
(def chas {:name "chas" :age 31 :location "massachusetts"})
(let [{:keys [name age location]} chas] (print name age location))#
 
 
 
 
关键字参数绑定
如果剩余部分元素个数是偶数个，顺序结构会把剩余部分当初一个map来处理
(def user-info ["robert8920" 2001 :name "Bob" :city "Boston"])
(let [[username account-year & {:keys [name city]}] user-info] (println username) (println name) (println city))
```

