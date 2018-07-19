(ns web-config-generator.webpack)


(defn entry
  "Add an webpack entry point"
  [name file]
  (fn [config] (assoc-in config [:webpack, :entries, name] file)))

(defn output
  "Define the webpack output"
  [path filename public-path]
  (fn [config] (assoc-in config [:webpack, :output, :output] {
                                                               :path path,
                                                               :filename filename,
                                                              :publicPath public-path

  })))

