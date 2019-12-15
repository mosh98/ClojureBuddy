(ns AnotherOne
  (:import (java.io FileReader File)))

;(vector [variable value])

(defmacro safe ( [expr]
                (try
                  `(do ~expr)
                  (catch Exception e ( (str "caught exception: " (.getMessage e) )))
                  )
                )

( [& expr]
 `(try
    (let ~(first expr)
      (try
        ~@(rest expr)
        (catch Exception e# (throw e#))
        (finally
          (let [x# (first ~(first expr))]
            (if (instance? java.io.Closeable x#)
              (.close x#))))))
    (catch Exception e# (str "Exception - " e#))))
  )







(def v (safe (/ 2 0)))
(println v )
;(def v (safe [s (FileReader. (File. "file.txt"))] (.read s)))

