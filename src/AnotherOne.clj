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
(import java.io.FileReader java.io.File)
(defmacro safe
  [& expression]
  '(try ~@expression
      (catch Exception e# (str " caught exception" e#)))
  '(try
     (with-open
       (~(first expression)) ~@(rest expression))
            (catch Exception #e (str "caught exception: " e#)))
     )


(defmacro safe
  [ & expression]
  (if (< (count expression)2)
    '(try ~@expression
          (catch Exception e# (str " caught exception" e#)))
    '(try
       (with-open
          ~(first expression) ~@(rest expression))
       (catch Exception #e (str "caught exception: " e#)))
    ))

(defmacro safe [& args]
  (if (< (.length args) 2)
    `(try
       (let ~(first args)
         (eval ~@(rest args)
               (catch Exception e# (str "<caught Exception: " (.getMessage e#) "!>" ))
               (finally
                 (let [exit# (first ~(first args))]
                   (if (instance? java.io.Closeable exit#) (.close exit#))))))
       (catch Exception e# (str "<caught Exception: " (.getMessage e#))))
    `(try
       ~@args
       (catch Exception e# (str "<caught Exception: " (.getMessage e#) "!>")))))








(def v (safe (/ 2 0)))
(println v )
;(def v (safe [s (FileReader. (File. "file.txt"))] (.read s)))

