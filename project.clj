(defproject clojure-lein "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  ;:main liu.learning.hello
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clj-time/clj-time "0.14.2"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [camel-snake-kebab "0.2.4"]
                 [org.clojure/core.async "0.7.559"]
                 [cheshire "5.9.0"]]
  :repl-options {:init-ns clojure-lein.hello}
  :plugins  [[lein-ring "0.12.5"]]
  :ring {:handler web.handler/app})
