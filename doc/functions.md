# Functions

Clojure是一个函数编程语言。 functions是一等公民，且functions可以作为其它返回值以及作为其它函数的参数使用。
大多数Clojure代码主要由纯函数（无副作用）组成，因此使用相同的输入调用会产生相同的输出。

## defn
定义一个函数
```$xslt
;;    name   params         body
;;    -----  ------  -------------------
(defn greet  [name]  (str "Hello, " name) )
```
这个函数有一个参数name， 调用这个函数很简单。
```$xslt
(greet "students")

"Hlelo, students"
```

## 多函数体functions
```$xslt
(defn messenger
  ([]     (messenger "Hello world!"))
  ([msg]  (println msg)))
```

这个function有两个函数体（0个参数和1个参数）， 分别返回不同的数据。

## 可变参数的functions
```$xslt
(defn hello [greeting & who]
  (println greeting who))
```
参数可变的标志是 &
这个函数有一个参数greeting和一个可变参数的 list 名称是who.
执行:
```$xslt
user=> (hello "Hello" "world" "class")
Hello (world class)
```

可以看到, greeting是Hello, 后边的是一个参数集合。

## 匿名函数
匿名函数使用fn定义.
```$xslt
;;    params         body
;;   ---------  -----------------
(fn  [message]  (println message) )
```

前边我们说了def是绑定一个变量，所以defn定义的函数就是一个匿名函数绑定到一个变量上。
你下边这样.
```$xslt
(defn greet [name] (str "Hello, " name))

(def greet (fn [name] (str "Hello, " name)))
```

## 匿名函数语法 
clojure使用 #()来简单的定义一个匿名函数
- %表示只有一个参数
- %1,%2, %3多参数表示
- %& 指可变参数

#(+ 6 %)
表示: (fn [x] (+ 6 x))

#(+ %1 %2)
表示:
(fn  [x y] (+ x y))

#(println %1 %2 %&)
表示:
(fn [x y &z] (println x y zs))

## Apply Functions
Apply的函数指调用0个或者多个固定参数的函数。并从最终序列中提取其余所需的参数。最后一个参数必须是一个序列
```$xslt
(apply f '(1 2 3 4))    ;; same as  (f 1 2 3 4)
(apply f 1 '(2 3 4))    ;; same as  (f 1 2 3 4)
(apply f 1 2 '(3 4))    ;; same as  (f 1 2 3 4)
(apply f 1 2 3 '(4))    ;; same as  (f 1 2 3 4)
```

像下边的例子
```$xslt
(defn plot [shape coords]   ;; coords is [x y]
  (plotxy shape (first coords) (second coords)))
```
你可以这样写 :
```$xslt
(defn plot [shape coords]
  (apply plotxy shape coords))
```

## 闭包
### let
使用let重新锁定一个变量的上下文。let将符号绑定到“词法范围”中的值。词法作用域为名称创建了一个新的上下文，嵌套在周围的上下文中。在let中定义的名称优先于外部上下文中的名称。
```$xslt
;;      bindings     name is defined here
;;    ------------  ----------------------
(let  [name value]  (code that uses name))
```
每个let可以定义0个或多个绑定，并且主体中可以具有0个或多个表达式。

```$xslt
(let [x 1
      y 2]
  (+ x y))
```

let 创建了两个变量，x ,y. (+ x y) 是在let范围的表达式， x=1, y=2, 在let之外，xy没有实际的意义。

### Closures
```$xslt
(defn messenger-builder [greeting]
  (fn [who] (println greeting who))) ; closes over greeting

;; greeting provided here, then goes out of scope
(def hello-er (messenger-builder "Hello"))

;; greeting value still available because hello-er is a closure
(hello-er "world!")
;; Hello world!
```