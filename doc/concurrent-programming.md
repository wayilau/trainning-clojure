# 并发编程
clojure中并发:
- 原子
- STM (ref)
- 使用agent

## 原子
类似Java中的原子，是一种CAS,来保证多线程时数据的安全性。原子只能针对一个值，多个值的状态需要保持时要用到了ref.

## ref
STM， 软事务内存. 与数据库的事务类似，原子性，一致性，隔离性。
```$xslt

(def alice-height (ref 3))

(def right-hand-bites (ref 10))

(defn eat-from-right-hand []
  (when (pos? @right-hand-bites)
    (alter right-hand-bites dec)
    (alter alice-height #(+ % 24))))
```
当执行(eat-from-right-hand)的时候，会报错 "No transaction running"

这说我们需要在一个事务之内运行， 通过dosync来做到。

```$xslt
(dosync (eat-from-right-hand))
```

## 使用代理(agent)独立管理状态
agent 是处理异步并发，使用agent来管理同步的修改， 引用用于协同的同步修改， agent则是独立的修改。


