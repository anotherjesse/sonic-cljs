(defproject devmusic "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "0.0-3308"]
                 [overtone "0.9.1"]
                 [devcards "0.2.0-SNAPSHOT"]
                 [sablono "0.3.4"]
                 [cljs-react-reload "0.1.0"]
                 #_[org.omcljs/om "0.8.8"]
                 #_[reagent "0.5.0"]]

  :plugins [[lein-cljsbuild "1.0.5"]
            [lein-figwheel "0.3.7"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "target"]
  
  :source-paths ["src"]

  :cljsbuild {
              :builds [{:id "devcards"
                        :source-paths ["src" "example_src"]
                        :figwheel { :devcards true
                                   ;; :heads-up-display false
                                   } ;; <- note this
                        :compiler { :main       "sonic-demos.core"
                                    :asset-path "js/compiled/devcards_out"
                                    :output-to  "resources/public/js/compiled/devmusic_devcards.js"
                                    :output-dir "resources/public/js/compiled/devcards_out"
                                    :source-map-timestamp true }}
                       {:id "dev"
                        :source-paths ["src"]
                        :figwheel true
                        :compiler {:main       "sonic-cljs.core"
                                   :asset-path "js/compiled/out"
                                   :output-to  "resources/public/js/compiled/devmusic.js"
                                   :output-dir "resources/public/js/compiled/out"
                                   :source-map-timestamp true }}]}

  :figwheel { :css-dirs ["resources/public/css"]
              :open-file-command "emacsclient"})
