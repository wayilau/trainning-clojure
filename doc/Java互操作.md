# clojure与java互操作
|TASK|JAVA|CLOJURE|
|:---|:---:|:---:|
|Instantiation|new Widget("foo")|(Widget. "foo")|
|Instance method|rnd.nextInt()|(.nextInt rnd)|
|Instance field|object.field|(.-field object)|
|Static method|Math.sqrt(25)|(Math/sqrt 25)|
|Static field|Math.PI|Math/PI|