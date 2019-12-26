# 高阶函数
## 函数作为参数
```
(defn double-+
    [a b]
    (* 2 (+ a b)))

```
一般定义如下:
````$xslt
(defn double-<f>
    [a b]
    (* 2 (f a b)))
````
dubbble-, 函数通过f传递作为参数.

## 返回function
```$xslt
(defn adder [x]
  (fn [a] (+ x a)))
```

## Filter

