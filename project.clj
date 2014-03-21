(defproject reagent-lambdaova-demo "0.1.0-SNAPSHOT"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2173"]
                 [reagent "0.4.2"]
                 [jayq "2.5.0"]]
  
  :cljsbuild {
    :builds [{
        :source-paths ["src"]
        :compiler {
          :output-to "web/js/app.js"
          :optimizations :whitespace
          :pretty-print true
        }}]
  })
