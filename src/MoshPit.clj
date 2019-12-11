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



;(defn safe[('args )]
;(try ((apply (first args)(rest args)) )
;     (catch ArithmeticException _
;       (println "Division by zero caught!")
;       ;(cond (> x 0)   Double/POSITIVE_INFINITY
;       ;      (zero? x) Double/NaN
;       ;      :else     Double/NEGATIVE_INFINITY)
;        )))

(defn say-hello
  "recieve a name with 1 paramtre and repsonds"
  [name]
  (println "Hello again " name)

  )

(say-hello "MOSH THE SAVGAE")

(defn get-sum-more
  ;"If three elements execute this shit"
  ([x y z ]
   (+ x y z))
  ;"Or if there is two elements execute this shit"
  ([x y]
   (+ x y))
  ;"else execute this shit"
  ([x]
   (* x 10)) )

(println (get-sum-more 1 ))




(defn hello-all
  [& names]
  (map say-hello names))


(defn when-ex
  [tof]
  (when tof
    (println "1st thing"))
    (println "2st thing")
  )


; while loops

;(defn one-to-x
;  [x]
;  (def i (atom 1)
;    (while (<= @i x)
;      (do
;        (
;         (println @i)
;         (swap! i inc)
;         ))
;      )))

(defn dbl-to-x
  [x]
  (dotimes [i x]
    (println (* i 2))))

;(defn triple-to-x
;  [x y]
;  (loop [i x]
;    (when (< i y))
;    (println (* i 3))
;
;    ))

(defn loopBoi [ x ]
  (loop [_ 20]
    (print x))
  )

(loopBoi "SKRR")

(defn loopBoi2 [ x y ]
(dotimes [_ y]
  (println x)
  )
  )
;(loopBoi2 "HAHA " 95)

(defmacro loopBoiMac [x y]
  (dotimes [_ (+ y 1 ) ]
    (println x)))

;(loopBoiMac "oke" 9)


(defn square
  [x]
  (do (
        (println "Processiong" x)
       (* x x) )))

(map square '(1 2 3 4 5 6 7 8 ))

;File I/O

;(use 'clojure.java.io)
;(defn write-to-file
;  [file text]
;  (with-open [wrtr (writer file)]
;    (.write wtr text))
;  )
;
;(defn read-from-file
;  [file]
;  ((try
;    (println slurp file)
;     (catch Exception e (println "ERROR: " (.getMessage e))
;       ))))
