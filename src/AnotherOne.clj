(ns AnotherOne)

;(vector [variable value])

(defmacro safe [list]
 `(do ~list)

  )


(def v (safe (/ 10 2)))
(println v )
