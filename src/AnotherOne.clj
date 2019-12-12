(ns AnotherOne)

;(vector [variable value])

(defmacro safe [list]


 (try
   `(do ~list)
  (catch Exception e (println (str "caught exception: " (.toString e))))
 )
  )



(def v (safe (/ 1 0)))
(println v )
