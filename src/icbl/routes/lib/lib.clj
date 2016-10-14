(ns icbl.routes.lib.lib)

(def data (slurp "C:/Users/medy/Desktop/SOAL.txt"))

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
