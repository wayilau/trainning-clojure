# Clojure syntax
这篇文章翻译官网: [Reading Clojure Characters](https://clojure.org/guides/weird_characters#_and_metadata)

clojure里有很多符号，在google里都查不到，这里给出解释。

```clojure
1. (...) List
2. [...] Vector
3. {...} Map
4. # 是一个Dispatch character,  告诉clojure读取下一个字符时使用的read table.
5. #{}  Set
6. #_ Discard 告诉reader 忽略掉后边的字符
7. #"..." 是正则表达式
8. #(...) 是匿名函数
9. #'  是返回一个var 函数
10. ## 符号值
11. % %n %&是匿名函数的参数
12. @ 用来舞台当前引用的值。
13 ^ (and #^) metadata marker



```

