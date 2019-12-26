# Hash 集合 
clojure 有四种重要的集合， vectors, lists, sets, maps.
set 和maps是hash集合， 设计用来高效查询元素。

## Sets
Sets无序，不重复。Sets用来检测集合中是否含有某个元素，删除任意元素。
```$xslt
(def players #{"Alice", "Bob", "Kelly"})
```

### 添加一个元素
```$xslt
user=> (conj players "Fred")
#{"Alice" "Fred" "Bob" "Kelly"}
```

### 删除一个元素
```$xslt
user=> (disj players "Bob" "Sal")
#{"Alice" "Kelly"}
```

### 检查是否包含一个元素
```$xslt
user=> (contains? players "Kelly")
true
```

### Sets 排序
```$xslt
user=> (conj (sorted-set) "Bravo" "Charlie" "Sigma" "Alpha")
#{"Alpha" "Bravo" "Charlie" "Sigma"}
```

### 合并Sets
使用into将一个collection合并到另一个
```$xslt
user=> (def players #{"Alice" "Bob" "Kelly"})
user=> (def new-players ["Tim" "Sue" "Greg"])
user=> (into players new-players)
#{"Alice" "Greg" "Sue" "Bob" "Tim" "Kelly"}
```

## Maps
Maps主要用为2个方面，1是管理键与值关系，2是表示应用域的数据。

### 创建maps
```$xslt
(def scores {"Fred"  1400
             "Bob"   1240
             "Angela" 1024})
```

### 添加元素 
user=> (assoc scores "Sally" 0)
{"Angela" 1024, "Bob" 1240, "Fred" 1400, "Sally" 0}
如果添加的元素key已经存在，则值会被替换

### 删除元素
user=> (dissoc scores "Bob")
{"Angela" 1024, "Fred" 1400}

### 查询元素
```$xslt
user=> (get scores "Angela")
1024
```
如果你想在查询时没有元素时返回一个默认值:
```$xslt
user=> (get scores "Sam" 0)
0
​
user=> (directions :northwest -1)
-1
```

###  是否包含
````$xslt
user=> (contains? scores "Fred")
true

user=> (find scores "Fred")
["Fred" 1400]
````

### 获取Keys或者 Values
```$xslt
user=> (keys scores)
("Fred" "Bob" "Angela")

user=> (vals scores)
(1400 1240 1024)
```

### zipmap
zipmap可以将两个序列合并成一个map.
```$xslt
user=> (def players #{"Alice" "Bob" "Kelly"})
#'user/players

user=> (zipmap players (repeat 0))
{"Kelly" 0, "Bob" 0, "Alice" 0}
```

### 合并maps
```$xslt
user=> (def new-scores {"Angela" 300 "Jeff" 900})
#'user/new-scores

user=> (merge scores new-scores)
{"Fred" 1400, "Bob" 1240, "Jeff" 900, "Angela" 300}

```

### map排序
```$xslt
user=> (def sm (sorted-map
         "Bravo" 204
         "Alfa" 35
         "Sigma" 99
         "Charlie" 100))
{"Alfa" 35, "Bravo" 204, "Charlie" 100, "Sigma" 99}

user=> (keys sm)
("Alfa" "Bravo" "Charlie" "Sigma")

user=> (vals sm)
(35 204 100 99)
```
 ## 第二种用法
 表示应用信息
 ```$xslt
(def person
  {:first-name "Kelly"
   :last-name "Keen"
   :age 32
   :occupation "Programmer"})
```
这里可以表示一个人的相关信息，并对信息进行修改。类似Java的class.

### 实体关联
```$xslt
(def company
  {:name "WidgetCo"
   :address {:street "123 Main St"
             :city "Springfield"
             :state "IL"}})
```
可以使用get-in来访问实体中任意字段
```$xslt
user=> (get-in company [:address :city])
"Springfield"
```

修改内联实体:
```$xslt
user=> (assoc-in company [:address :street] "303 Broadway")
{:name "WidgetCo",
 :address
 {:state "IL",
  :city "Springfield",
  :street "303 Broadway"}}
```

## Records
一种替代maps的方法。
```$xslt
;; Define a record structure
(defrecord Person [first-name last-name age occupation])

;; Positional constructor - generated
(def kelly (->Person "Kelly" "Keen" 32 "Programmer"))

;; Map constructor - generated
(def kelly (map->Person
             {:first-name "Kelly"
              :last-name "Keen"
              :age 32
              :occupation "Programmer"}))
```

Records的用法几乎与Maps完全相同，但要注意的是，它们不能像地图一样作为函数调用。



