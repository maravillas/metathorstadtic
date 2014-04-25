goog.addDependency("base.js", ['goog'], []);
goog.addDependency("../cljs/core.js", ['cljs.core'], ['goog.string', 'goog.array', 'goog.object', 'goog.string.StringBuffer']);
goog.addDependency("../clojure/string.js", ['clojure.string'], ['cljs.core', 'goog.string', 'goog.string.StringBuffer']);
goog.addDependency("../metathorstadtic/gen.js", ['metathorstadtic.gen'], ['cljs.core', 'clojure.string']);
goog.addDependency("../metathorstadtic/core.js", ['metathorstadtic.core'], ['cljs.core', 'goog.events', 'metathorstadtic.gen']);