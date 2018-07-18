(ns web-config-generator.core
    (:require ["web-config-generator.babel" :as babel]
              ["cljs.pprint"]))

(def baseconf
    "Base configuration"
    {:env {} :babel {:plugins [] :presets []}})

(defn env
    "Add an environment variable to the config"
    [name value]
    (fn [config] (assoc-in config [:env, name] value)))

(defn run
    "Compose and execute all functions defined in run"
    [baseconf & args]
    ((apply comp args) baseconf))

(def run-with-baseconf (partial run baseconf))

(cljs.pprint/pprint
    (run-with-baseconf
        (env "PORT" 9000)
        (env "TEST" "Titouan")
        (babel/plugin "jsx-transformer2" :config {:loose "titouan2"})
        (babel/plugin "Test")
        (babel/preset "react-preset" :config {:test "titouan"})))

