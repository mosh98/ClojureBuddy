(ns AnotherOne
  (:import (java.io FileReader File)))

;(vector [variable value])

;(defmacro safe ( [expr]
;                (try
;                  `(do ~expr)
;                  (catch Exception e ( (str "caught exception: " (.getMessage e) )))
;                  )
;                )
;
;( [& expr]
; `(try
;    (let ~(first expr)
;      (try
;        ~@(rest expr)
;        (catch Exception e# (throw e#))
;        (finally
;          (let [x# (first ~(first expr))]
;            (if (instance? java.io.Closeable x#)
;              (.close x#))))))
;    (catch Exception e# (str "Exception - " e#))))
;  )


(defmacro safe [& args]
  (if (< (count args) 2)
    `(try
       ~@args
       (catch Exception e# (str "<caught Exception: " (.getMessage e#) "!>") ))

    `(try
       (let ~(first args)
         (eval ~@(rest args)
               (catch Exception e# (str "<caught Exception: " (.getMessage e#) "!>" ))

               (finally
                 (let [exit# (first ~(first args))]

                   (if (instance? java.io.Closeable exit#) (.close exit#)

                   )

                 )
               )
         )
       )
       (catch Exception e# (str "" (.getMessage e#)))


    )

  )
)


(defmacro safe
  ([expression]
   `(try
      (do ~expression)
      (catch Exception e# (throw e#))))
  ([expression & variable]
   `(try
      (with-open ~expression ~@variable)
      (catch Exception e# (throw e#)))))





(def v (safe (/ 2 0)))
(println v )
;(def v (safe [s (FileReader. (File. "file.txt"))] (.read s)))

