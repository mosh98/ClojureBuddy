(ns tryMacro)


(defmacro safe [& args]
  `(try
     (do ~@args)
        (catch Exception e#
          (str "#<" (str (str e# ) ">") )
        )
  )
)
