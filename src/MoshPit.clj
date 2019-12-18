(ns MoshPit)

(import java.io.FileReader java.io.File)
(import java.io.Closeable)



;(println (eval (+ 1 2)) )
;
;
;;(defn [])
;
;
;;(defmacro safe
;;  [args]
;;
;;  (try
;;  (eval ( (first args) (rest args) ) )
;;
;;     (catch ArithmeticException e1 (str "caught exception: "(.getMessage e1)) )
;;   )
;;        )
;
;;(safe (/ 2 0))
;
;
;
;;(defn safe[('args )]
;;(try ((apply (first args)(rest args)) )
;;     (catch ArithmeticException _
;;       (println "Division by zero caught!")
;;       ;(cond (> x 0)   Double/POSITIVE_INFINITY
;;       ;      (zero? x) Double/NaN
;;       ;      :else     Double/NEGATIVE_INFINITY)
;;        )))
;
;(defn say-hello
;  "recieve a name with 1 paramtre and repsonds"
;  [name]
;  (println "Hello again " name)
;
;  )
;
;(say-hello "MOSH THE SAVGAE")
;
;(defn get-sum-more
;  ;"If three elements execute this shit"
;  ([x y z ]
;   (+ x y z))
;  ;"Or if there is two elements execute this shit"
;  ([x y]
;   (+ x y))
;  ;"else execute this shit"
;  ([x]
;   (* x 10)) )
;
;(println (get-sum-more 1 ))
;
;
;
;
;(defn hello-all
;  [& names]
;  (map say-hello names))
;
;
;(defn when-ex
;  [tof]
;  (when tof
;    (println "1st thing"))
;    (println "2st thing")
;  )
;
;
;; while loops
;
;;(defn one-to-x
;;  [x]
;;  (def i (atom 1)
;;    (while (<= @i x)
;;      (do
;;        (
;;         (println @i)
;;         (swap! i inc)
;;         ))
;;      )))
;
;(defn dbl-to-x
;  [x]
;  (dotimes [i x]
;    (println (* i 2))))
;
;;(defn triple-to-x
;;  [x y]
;;  (loop [i x]
;;    (when (< i y))
;;    (println (* i 3))
;;
;;    ))
;
;(defn loopBoi [ x ]
;  (loop [_ 20]
;    (print x))
;  )
;
;(loopBoi "SKRR")
;
;(defn loopBoi2 [ x y ]
;(dotimes [_ y]
;  (println x)
;  )
;  )
;;(loopBoi2 "HAHA " 95)
;
;(defmacro loopBoiMac [x y]
;  (dotimes [_ (+ y 1 ) ]
;    (println x)))
;
;;(loopBoiMac "oke" 9)
;
;
;(defn square
;  [x]
;  (do (
;        (println "Processiong" x)
;       (* x x) )))
;
;(map square '(1 2 3 4 5 6 7 8 ))
;
;;File I/O
;
;;(use 'clojure.java.io)
;;(defn write-to-file
;;  [file text]
;;  (with-open [wrtr (writer file)]
;;    (.write wtr text))
;;  )
;;
;;(defn read-from-file
;;  [file]
;;  ((try
;;    (println slurp file)
;;     (catch Exception e (println "ERROR: " (.getMessage e))
;;       ))))
;
;(for-loop [a 0]
;          (< a 10) (inc a)
;          (print a))

;
;(def mosh {
;           :Key      1
;           :another  one
;           :another2 two
;           :another3 32
;           })




; (defmacro select
; [coloum from]

; )

(def direction {
                :north 0
                :east 1
                :south 2
                :west 3})


(direction :north)




(def persons '({:id 4 :name "beatrice"}
               {:id 1 :name "olle"}
               {:id 3 :name "isak"}
               {:id 2 :name "anna"}
               ))


;(select [:id :name] from persons where [:id > 2] orderby :name)
;;({:id 4 :name "beatrice"} {:id 3 :name "isak"})

;(select-keys {persons} [:a])

;(defmacro select
;;  [var _ out _ coll _ wherearg _ orderarg]
;;
;;
;;
;;  )

;(defn print-coordinates-1 [point]
;  (let [x (first point)
;        y (second point)
;        z (last point)]
;    (println "x:" x ", y:" y ", z:" z)))
;
;(print-coordinates-1 [2 3 6])
;
;
;
;(doseq [[k x] direction]
;  (println k ":" x)
;  )
;(get direction 2)

(sort-by :id persons)
;sorts person by NAME

(doall (map #(println %) persons))
;prints out everyTHING


;In Clojure, the underscore is used idiomatically to indicate that the argument it identifies is not subsequently used.
(defmacro selectSort
  [out _ orderArgs]
  ;(map #(sort-by out orderArgs))
  (into (sorted-map-by (fn [key1 key2]
                         (compare [(get x key2) key2]
                                  [(get x key1) key1])
                         )
                       )
        x)
  )

(defn filter-by-id-over [arg]
  (filter arg #(> % id-val)
          )
          )

;(defmacro select
;  [var _ out _ coll _ wherearg _ orderarg]
;  `(map #(select-keys [~var] ~out)
;        (filter (fn [~var] ~wherearg)
;                (sort-by (fn [~var] ~orderarg)
;                         ~coll)                             ;for sortby
;                )                                           ;for filter
;        )                                                   ;formap
;  )

  (defmacro select
    [columns _ coll _ wherearg _ orderarg]
    `(map #(select-keys % (into [] ~columns))

          (filter #((second wherearg) (% (first wherearg)) (last wherearg))
                  (sort #(compare (~orderarg %1) (~orderarg %2))
                        ~coll))

          )
    )