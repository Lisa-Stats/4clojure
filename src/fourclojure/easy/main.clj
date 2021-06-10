(ns fourclojure.easy.main)

;;answered
;;last element
(comment
  (fn [coll]
    (first (reverse coll)))

  ;;other possible answers
  ;;can use threadfirst or threadlast in this case
  ;;usually use thread macro when using 3 operations or more
  ((fn [coll]
     (-> coll reverse first)) [1 2 3])

  ((fn [coll]
     (first (into '() coll))) [1 2 3 4 5]))

;;penultimate element
(comment
  (fn [coll] (last (butlast coll)))

  ;;other possible answers
  ;;can use threadfirst or threadlast in this case
  ((fn [coll]
     (-> coll butlast last)) [1 2 3 5]))

;;count a sequence
(comment
  (fn [coll]
    (reduce + (map (constantly 1) coll))))

;;sum it all up
(comment
  reduce +)

;;find the odd numbers
(comment
  (filter (fn [x] (= 1 (mod x 2)))
          #{1 2 3 4 5})
  (filter odd? [1 2 3])
  ;;ans = filter odd?
  )

;;reverse a sequence
(comment
  ;;this solution only works on sorted collection
  ((fn [coll]
     (sort #(compare %2 %1) coll)) [1 2 4 5])

  ;;other possible solutions
  ;;this will work on all types of seqs
  ((fn [coll]
     (reduce conj '() coll)) [2 5 1 4]))

;;maximum value
(comment
  (fn [& xs]
    (last (sort xs))))

;;get the caps
(comment
  (fn [string]
    (apply str
           (re-seq #"[A-Z]+" string))))

;;duplicate a sequence
(comment
  (fn [coll]
    (sort
     (apply concat
            (list* (repeat 2 coll)))))

;;replicate a seq
(comment
  #(mapcat (partial repeat %2) %1)
  )

  ;;other possible answers
  (#(interleave % %) [1 2 3])
  ((fn [coll]
     (interleave coll coll)) [1 2 3])

  (#(interleave %1 %2) [1 2 3] ["one" "two" "three"])
  ((fn [coll coll2]
     (interleave coll coll2))
   [1 2 3] ["one" "two" "three"]))

;;intro to some
(comment
  6

  ;;set can be used as a predicate function
  ;;#{2 1} are truthy values and the collection, go through
  ;;each element one at a time and evaluate if true, if so
  ;;returns the first truthy value (ans = 1)
  (some #{2 1} #{1 2 3 5})

  ;;some is asking if there is at least one number that is
  ;;divisible by 4 in collection
  ;;there is, so it returns true
  ;;that is why we add when, so we can return the number
  ;;some is a performance benefit: does not look through the
  ;;entire collection, stops at first logical true
  ;;faster version of filter, if don't care about looking at
  ;;entire collection
  ;;filter will give back a new collection, some will return
  ;;the answer to the predicate
  ;;very niche use case
  (some (fn [x]
          (when (= 0 (mod x 4)) x))
        [5 6 8 16]))

;;factorial fun
 ;;in recur, we are stating in order what each variable becomes on the next iteration
(comment
  ;;answer
  ((fn [n] (loop [n n    ;;variable 1 - (dec n)
                  acc 1  ;;variable 2 - (* acc n)
                  ]
             (if (> n 0) ;;on the next iteration, change the value of each variable
               (recur    ;;on the next iteration, n becomes n - 1
                (dec n)  ;;on the next iteration, acc becomes acc * n
                (* acc n))
               acc))) 3)

  ;;step 1
 ;; n = 3      <-- when the loop starts its these values
 ;; acc = 1

 ;; n - 1 = 2  <-- when the loop ends its these values and it passes them as
 ;; acc * n = 3    the new loop initializers for the next step (loop)

  ;;step 2
 ;; n = 2      <-- the loop restarts with values from the end of the last
 ;; acc = 3         loop

 ;; n - 1 = 1  <-- when the loop ends its these values and it passes them as
 ;; acc * n = 6

  ;;step 3
 ;; n = 1      <-- the loop restarts with values from the end of the last
 ;;  acc = 6       the new loop initializers for the next step (loop)

 ;; n - 1 = 0  <-- when the loop ends its these values and it passes them as
 ;; acc * n = 6    the new loop initializers for the next step (loop)

  ;;step 4
  ;;wait, n = 0, so I should return the acc which is now 6 <-- meet exit condition

  ;;other possible answers
  (range 1 (+ 8 1))
  (#(reduce * (range 1 (+ % 1))) 3)
  ((fn [n]
     (reduce * (range 1 (+ n 1)))) 3))

;;intro to iterate
(comment
  '(1 4 7 10 13)
  (take 5 (iterate #(+ % 3) 2))
  ;;when start java program, tell them how much memory we
  ;;are alloted, for example can say give me 4 gbs of memory,
  ;;and that is how much memory we can play with
  ;;clojure can go through extremely large collections b/c
  ;;it goes through it lazily
  ;;it takes it in managable chunks and goes through it,
  ;;chunk by chunk
  ;;disadvantage: lazy seqs are a bit dangerous b/c if wrote
  ;;something that went through a lazy seq and make a mistake
  ;;where it continually calls it infinitely or getting a
  ;;millionor billion elements and everyone else is going to be
  ;;waiting for that to finish
  ;;need to be extra careful writing seqs

  ;;loop recur issue, that effected repl and I had to restart.
  ;;when clojure repl starts, java allots it a certain amount
  ;;of memory b/c it is a java program
  ;;my loop kept going and going until it used up all possible
  ;;memory and then just died
  ;;java says it cannot do any more b/c it does not have any
  ;;more memory left b/c all of it was used up with infinite
  ;;loop call
  ;;so it throws the OOM error
  )

;;contain yourself
(comment
  4)

;;interpose a seq
(comment
  ((fn [n coll]
     (rest (interleave (repeat n) coll))) 0 [1 2 3])

  (#(rest (interleave (repeat %1) %2)) 0 [1 2 3]))

;;intro to destructuring 2
(comment
;;+ a
  )

;;advanced destructuring
(comment
  [1 2 3 4 5]

  (let [[a b & c :as d] [1 2 3 4 5]]
    [a b c d]))

;;set intersection
(comment
  (fn [coll coll2]
    (into #{}
          (filter coll coll2))))

;;nth element
(comment
  #((apply comp first (repeat %2 rest)) %1))

;;indexing seqs
(comment
  (#(map list % (range)) [1 2 3]))

;;drop every nth item
(comment
  (fn [coll n]
    (flatten (partition-all (- n 1) n coll)))
  )

;;compress a sequence
(comment
  #(map first (partition-by identity %))
  )

;;pack a seq
(comment
  (fn [coll]
    (partition-by identity coll))
  )

;;interleave two sequences
(comment
  (fn [coll coll2]
    (mapcat vector coll coll2))
  )

;;map construction
(comment
  (fn [coll coll2] (apply assoc {}
                         (interleave coll coll2)))
  )

;;fibonacci sequence
(comment
  (fn [x] (take x
              (map first (iterate
                          (fn [[a b]] [b (+ a b)]) [1 1]))))
  )

;;split a seq
(comment
  #((juxt take drop) %1 %2)
  )

;;implement range
(comment
  (fn [n1 n2]
    (loop [n1 n1
           acc '()]
      (if (< n1 n2)
        (recur (dec n1) (cons n1 acc))
        (reverse acc)))))

;;re-implement map
(comment
  (fn map* [f ls]
    (lazy-seq
     (if (empty? ls)
       ()
       (cons (f (first ls))
             (map* f (rest ls)))))))

;;cartesian product
(comment
  (fn [s1 s2]
    (into #{}
          (for [x s1
                y s2]
            [x y]))))

;;palindrome detector
(comment
  (fn [coll] (if (string? coll)
               (= coll (apply str (reverse coll)))
               (= coll (reverse coll)))))


;;product digits
(comment
  #(->> (* %1 %2)
        (str)
        (seq)
        (map str)
        (map read-string)
        (into [])))

;;simple closures
(comment
  (fn [n] #(apply * (repeat n %))))

;;infix calculator
(comment
  (fn infix
    ([num1 op num2] (op num1 num2))
    ([num1 op num2 & nums]
     (apply infix (cons (infix num1 op num2) nums)))))

;;flatten a seq
(comment
  (fn flatten* [coll]
    (if (sequential? coll)
      (mapcat flatten* coll)
      (list coll))))

;;greatest common divisor
(comment
  (fn gcd [x y]
    (if (= y 0)
    x
    (gcd y (mod x y)))))

;;least common multiple
(comment
  (fn lcm-4clj
    ([x y]
     (letfn [(gcd [x y] (if (= 0 y) x (recur y (mod x y))))]
       (/ (* x y) (gcd x y))))
    ([x y & nums]
     (apply lcm-4clj (cons (lcm-4clj x y) nums)))))

;;sum of square of digits
(comment
  (fn [coll]
    (let [get-digits (fn [n] (->> n
                                  (str)
                                  (seq)
                                  (map str)
                                  (map #(Integer/parseInt %))))
          digits-squared (fn [n] (apply + (map #(* % %) (get-digits n))))
          result-seq (filter #(< % (digits-squared %)) coll)]
      (count result-seq))))

;;read a binary number
(comment
  (fn [s]
  (reduce (fn [x y] (+ (* x 2) y)) (map read-string (map str (seq s))))))


;;unanswered
;;a half-truth
(comment)

;;re-implement iterate
(comment)

;;comparisons
(comment)

;;group a seq
(comment)

;;symmetric difference
(comment)

;;dot product
(comment)

;;through the looking class
(comment)

;;pascal's triangle
(comment)

;;to tree, or not to tree
(comment)

;;recognize playing cards
(comment)

;;beauty is symmetry
(comment)

;;pascal's trapezoid
(comment)

;;trees into tables
(comment)

;;pairwise disjoint sets
(comment)
