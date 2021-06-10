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

;;find distinct items
(comment
  (fn [coll] (if (> (count coll) 5)
               (sort (map first (frequencies coll)))
               (map first (frequencies coll)))))

;;partition a sequence
(comment
  (fn [n coll]
  (loop [acc []
         coll coll]
    (if (< (count coll) n)
      acc
      (recur (conj acc (take n coll))
             (drop n coll))))))

;;happy numbers
(comment
  (fn happy [n]
    (letfn [(happy-number [n]
              (take 20
                    (take-while #(> % 1)
                                (iterate (fn [n] (->> n
                                                      (str)
                                                      (seq)
                                                      (map str)
                                                      (map #(Integer/parseInt %))
                                                      (map #(* % %))
                                                      (apply +))) n))))]
      (if (> (count (happy-number n)) 15)
        false
        true))))
