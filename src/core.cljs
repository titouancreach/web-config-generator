(ns configurator.core
    (:require ["fixture.test" :as config]))

(def baseconf
    "Base configuration"
    {:env {}})

(defn env
    "Add an environment variable to the config"
    [name value]
    (fn [config] (assoc-in config [:env, name] value)))

(defn run
    "Compose and execute all functions defined in run"
    [baseconf & args]
    ((apply comp args) baseconf))

(def run-with-baseconf (partial run baseconf))



(println
    (run-with-baseconf
        (env "PORT" 9000)
        (env "TEST" "Titouan")))

