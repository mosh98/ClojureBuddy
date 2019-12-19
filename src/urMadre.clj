(ns urMadre)



  ;(defmacro select
  ;  [var _ out _ coll _ wherearg _ orderarg]
  ;
  ;  (map (fn [n] (. n toUpperCase))
  ;       (filter (fn [n] (> (. n length) 2))
  ;               (sort-by (fn [n] (. n length))
  ;                        coll))
  ;       )
  ;
  ;  )

(defmacro select
  [var _ out _ coll _ wherearg _ orderarg]
  `(map (fn [~var] ~out)
        (filter (fn [~var] ~wherearg)
                (sort-by (fn [~var] ~orderarg)
                         ~coll))))
(defmacro select
  [var _ out _ coll _ wherearg _ orderarg]
  `(map #(select-keys [~var] ~out)
        (filter (fn [~var] ~wherearg)
                (sort-by #(fn [~var] ~orderarg)
                         ~coll))))

(def ok '("muha", "haha","huahua","haha"))






(def direction {
                :north 0
                :east 1
                :south 2
                :west 3})


(def persons '({:id 4 :name "beatrice"}
               {:id 1 :name "olle"}
               {:id 3 :name "isak"}
               {:id 2 :name "anna"}
               ))

(sortListBy persons where :id)

(defmacro sortListBy
  [from _ orderby]
`(sort-by ~orderby ~from)
  )

;(select [:id :name] from persons where [:id > 2] orderby :name)

(defmacro select
  [columns _ source _ wherearg _ orderarg]
    `(map #(select-keys % (into [] ~columns))
          (filter #((second ~wherearg) (% (first ~wherearg)) (last ~wherearg))
             (sort-by ~orderarg ~source
             )
          )
    )
)



