(defproject metathorstadtic "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2173"]]

  :plugins [[lein-cljsbuild "1.0.2"]]

  :source-paths ["src"]

  :cljsbuild { 
    :builds [{:id "metathorstadtic"
              :source-paths ["src"]
              :compiler {
                :output-to "metathorstadtic.js"
                :output-dir "out"
                :optimizations :advanced}}]})
