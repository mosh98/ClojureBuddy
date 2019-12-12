(ns AnotherOne
  (:import (java.io FileReader File)))

;(vector [variable value])

(defmacro safe ( [expr]
                (try
                  `(do ~expr)
                  (catch Exception e ( (str "caught exception: " (.getMessage e) )))
                  )
                )
(
 [[elem1 elem2]expr]
  `(do elem1 elem2)
 `(do ~expr)
 )



  )



(def v (safe (/ 2 0)))
(println v )
;(def v (safe [s (FileReader. (File. "file.txt"))] (.read s)))

