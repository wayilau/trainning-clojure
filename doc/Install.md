# Install

## 我用Mac开发，所以直接使用:
```
brew install clojure
```

##  linux:
```
curl -O https://download.clojure.org/install/linux-install-1.10.1.492.sh
chmod +x linux-install-1.10.1.492.sh
sudo ./linux-install-1.10.1.492.sh
```

## windows:
```aidl
git clone https://github.com/clojure/clojure.git
cd clojure
mvn -Plocal -Dmaven.test.skip=true package
```

启动REPL
```
java -jar clojure.jar
```