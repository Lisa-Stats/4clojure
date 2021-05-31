(ns fourclojure.medium.main)

;;intro to trampoline
(comment
  [1 3 5 7 9 11])

;;perfect numbers
(comment
  (fn [n] (= n (apply + (butlast (filter #(= 0 (mod n %)) (range 1 10000)))))))

;;anagram finder
(comment
  (fn [coll]
    (into #{}
          (remove #(= (count %) 1)
                      (map set (vals (group-by sort coll)))))))
