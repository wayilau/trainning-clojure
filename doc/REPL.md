# REPL
REPL 是(Read-Eval-Print-Loop)的缩写。
1. 读取一个expression(a string of characters) 用于Clojure data.
2. 计算返回的数据
3. 打印结果，从clojure data转换到 characters.
4. 循环回到步骤1.

很重要的一点就是clojure没有自己的解释器，都是把代码编译成JVM bytecode.


## 在REPL中探索
- *1 代表最后一个result
- *2 当前前面两个结果
- *3 当前前面三个结果

### 包加载
在REPL中有一个namespace:  clojure.repl， 他由一个clojure的标准库提供一些很有帮助的函数.

(require '[clojure.repl] :refer :all)
加载这个包好让它在当前上下文中 使用。

### doc
doc 函数显示了其它函数的文档 

### apropos
这个函数主要是用来查询其它字符代码的函数有哪些，好让你确定一下 当你使用一个符号的时候，有哪些函数被调用。

### find-doc
名字就知道了，查询一个字符串在哪个函数的文档里出现了。

### source
查看源码。

## clojure 基础

### def 

当你使用REPL的时候会保存上边的表达式的值供后边的使用， dev也可以做到.
(def x 7) 就定义了 一个变量并给他赋值为7.
当执行(+ x x)的时候结果就是14.

### Printing
println/prn
print/pr

