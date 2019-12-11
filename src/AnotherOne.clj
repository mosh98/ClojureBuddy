(ns AnotherOne)

;(vector [variable value])

(defmacro safe ([expr]
               (reduce (first expr) (rest expr))
                ))

(def v (safe (/ 12 4)))
(println v "  hehehe")
