(ns MoshPit)

(import java.io.FileReader java.io.File)
(import  java.io.Closeable)



;(println (eval (+ 1 2)) )


;(defn [])


;(defmacro safe
;  [args]
;
;  (try
;  (eval ( (first args) (rest args) ) )
;
;     (catch ArithmeticException e1 (str "caught exception: "(.getMessage e1)) )
;   )
;        )

;(safe (/ 2 0))

(def x [+ 2 3] )

(defn safe[f & args]
(try ( (apply f (list args)) )
     (catch ArithmeticException _
       (println "Division by zero caught!")
       ;(cond (> x 0)   Double/POSITIVE_INFINITY
       ;      (zero? x) Double/NaN
       ;      :else     Double/NEGATIVE_INFINITY)
        )))


(defn x (safe + 1 0))