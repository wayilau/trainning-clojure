# REPL
REPL 是(Read-Eval-Print-Loop)的缩写。
1. 读取一个expression(a string of characters) 用于Clojure data.
2. 计算返回的数据
3. 打印结果，从clojure data转换到 characters.
4. 循环回到步骤1.


## 在REPL中探索
- *1 代表最后一个result
- *2 当前前面两个结果
- *3 当前前面三个结果

### 包加载
在REPL中有一个namespace