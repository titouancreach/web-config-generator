# Static web config generator

When starting a new project it is very painfull to set up all the config file like:
  - webpack.config.js
  - .babelrc
  - .postcss
  - .browserlistrc
  - ...

`Static web config generator` aims to simplify this process in defining one config file that is in charge to generate
all the boiler plate.

This config is written in Clojure (lispy). Why:
  - Hygienic macros
  - Readable and declarative
  - Functional (easy configs composition)
  - Greate import system

  Example

  ```clojure
    (config "build:dev"
        (env "NODE_ENV" "development")
        (babel/plugin "myAwesomeBabelPlugin")
        (babel/presets "myAwesomeBabelPreset")
        (webpack/entry "./src/index.js")
        (webpack/output "build")
  ```

  With clojure, we can easly create shared config

  ```clojure
  (def babel-shared [(babel/plugin "transform-jsx"), (babel/presets "react")])
  (def config-prod (partial config "build:prod" (babel/plugin "mySpecificPlugin")))
  (apply config-prod babel-shared)
 ```

 `static web config generator` can also patch your package.json to add your configs as a script

