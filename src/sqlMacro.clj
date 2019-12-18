(ns sqlMacro)

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
