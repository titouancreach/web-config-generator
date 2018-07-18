(ns web-config-generator.babel)

(defn add-in
  [baseconf, key, elem]
  (let [target (get-in baseconf [:babel, key])]
    (assoc-in baseconf [:babel, key] (conj target elem))))

(defn plugin
  "Add a babel plugin"
  [name & {:keys [config] :or {config {}}}]
  (fn [baseconf]
    (add-in baseconf :plugins [name, config])))

(defn preset
  "Add a babel preset"
  [name & {:keys [config] :or {config {}}}]
  (fn [baseconf]
    (add-in baseconf :presets [name, config])))
