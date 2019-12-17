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

(select n as (. n toUpperCase)
        from ok
        where (> (. n length)2)
        orderby (. n length)
        )

