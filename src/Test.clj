(ns Test)

;(println (cons 3 (list 1 2 )))                              ;; con-joins the shit

; (print (conj (set '(3 2)) 1))

; (println (contains? (set '(3 2)) 2)) checks if 2 is in the declared set

; (println (hash-map "Name" "Derek" "Age" 42)) the first argument is a key then a value very simple

; (print (find (hash-map "Name" "Derek" "Age" 42) "Name"))


; take a list of elemnts and retern the last element
;(defmacro safe [(vec &args) ()])

(defmacro unless [cond FASLE TRUE]
  (list 'if cond
        TRUE FASLE))


(unless (= 2 3)
        (print "not the same!")
        (print "the same"))



(println "======================")
(println "   ")
(println "         ")

(defmacro infix [operand1 operator operand2]
  (list operator operand1 operand2)
  )
;;(println (infix 1 + 2 ))

(println "======================")
(println "   ")
(println "         ")

(defmacro for-loop [init cond inc form]
  `(loop ~init
     (if ~cond
       (do ~form
           (recur ~inc))
       ~(first init))))

(println (range 3 7))

(println (for [x (range 3 7)]
           (* x x)))


(for [[x y] '([:a 1] [:b 2] [:c 0]) :when (= y 0)] x)
