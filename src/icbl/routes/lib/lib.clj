(ns icbl.routes.lib.lib)

;;Parse data
(def data ["sss"])

(defn p-dat [dat]
  (partition-by #(= \newline %) dat))

(defn parse-dat [dat]
  (partition-all 5
    (map #(apply str %) (filter #(or (and (and (>= (int (first %)) 65)
                                               (<= (int (first %)) 69)) 
                                          (= (nth % 1) \.) 
                                          (= (nth % 2) \space))
                                     (and (> (Character/digit (first %) 10) 0) 
                                          (= (nth % 1) \.) 
                                          (= (nth % 2) \space)))
                                (p-dat dat)))))

;;Script Rapor
(def rname "Suparjo")
(def m-nilai {:subject "Fisika" :nilai "98"})
(def l-nilai {:subject "Bahasa Inggris" :nilai "56"})
(def bla-nilai {:subject "Kesenian" :nilai "46"})
(def ala-nilai {:subject "Matematika" :nilai "86"})

(defn rapor [mn ln al bl]
  (str rname " unggul dalam pelajaran " (:subject mn) 
       " dengan nilai " (:nilai mn) ". Namun dalam pelajaran " 
       (:subject ln) ", dia meraih nilai yang rendah dengan nilai "
       (:nilai ln) ". Dia meraih nilai " (:subject al) " yang diatas rata-rata kelas."
       " Namun masih perlu bekerja lebih giat lagi dalam pelajaran " 
       (:subject bla-nilai)))

