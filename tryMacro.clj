(ns tryMacro)


(defmacro safe
  ([& args]
   `(try
      (do ~@args)


      (catch Exception e#
        (str "#<" (str (str e#) ">"))
        )
      )
   )
  )

(defmacro safe
  [& args]
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

      (catch Exception e#
        (str "#<" (str (str e#) ">"))
        )
      )

  )



(def v (safe (/ 10 2)))
(import java.io.FileReader java.io.File)
(def v (safe [s (FileReader. (File. "file.txt"))] (.read s)))

(def v (safe [s (FileReader. (File. "missing-file"))] (. s read)))
