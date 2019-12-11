(ns AnotherOne)

;(vector [variable value])
(defmacro safe ([expr]
                (let [x  (apply(first expr) (list (rest expr) ) )]
                  ( x))
                ) )

(def v (safe (/ 12 4)))
v
