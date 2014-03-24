reagent-lambdaova-demo
======================

A very simple [Reagent](https://github.com/holmsand/reagent) TODO app example - coded live at a [Lambda Meetup in Ostrava, CZ](https://plus.google.com/communities/110902954360410928675). Unedited version :)

The slides I was showing can be found [here](https://speakerdeck.com/dkvasnicka/reagent-clojurescript-3-react).

Howto
-----

1. Make sure you have Leiningen installed
1. Install [lein-cljsbuild](https://github.com/emezeske/lein-cljsbuild) - either add it to this project's `project.clj` or put it into `~/.lein/profiles.clj`
1. Run `lein do cljsbuild clean, cljsbuild auto` to turn on automatic ClojureScript compilation
2. Go to the `web` subfolder and have it served via some HTTP server, e.g. `python -m SimpleHTTPServer`
3. Hack away!