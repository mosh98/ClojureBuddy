(ns sqlMacro)

(defmacro select
  [columns _ coll _ wherearg _ orderarg]
  `(map #(select-keys % (into [] ~columns))
        (filter #((second ~wherearg) (% (first ~wherearg)) (last ~wherearg))
                (sort #(compare (~orderarg %1) (~orderarg %2))
                 ~coll)
         )
    )

)



;MOSLEH SOLUTION

(defmacro select
  [columns _ source _ wherearg _ orderarg]
  `(map #(select-keys % ~columns )
        (filter #((second ~wherearg) (% (first ~wherearg)) (last ~wherearg))
                (sort-by ~orderarg ~source
                         )
                )
  )
  )