(defproject clojure-lein "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :main liu.learning.hello
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clj-time/clj-time "0.14.2"]]
  :repl-options {:init-ns clojure-lein.hello})
