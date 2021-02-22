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
(comment
  ;;answer
  ((fn [n] (loop [n n
                  acc 1]
             (if (> n 0)
               (recur (dec n) (* acc n))
               acc))) 3)

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


;;unanswered
;;palindrome detector
(comment)

;;fibonacci sequence
(comment)

;;implement range
(comment)

;;flatten a seq
(comment)

;;split a seq
(comment)

;;a half-truth
(comment)

;;map construction
(comment)

;;greatest common divisor
(comment)

;;simple closures
(comment)

;;re-implement iterate
(comment)

;;comparisons
(comment)

;;cartesian product
(comment)

;;product digits
(comment)

;;group a seq
(comment)

;;symmetric difference
(comment)

;;dot product
(comment)

;;read a binary number
(comment)

;;through the looking class
(comment)

;;infix calculator
(comment)

;;pascal's triangle
(comment)

;;to tree, or not to tree
(comment)

;;re-implement map
(comment)

;;sum of square of digits
(comment)

;;recognize playing cards
(comment)

;;least common multiple
(comment)

;;beauty is symmetry
(comment)

;;pascal's trapezoid
(comment)

;;trees into tables
(comment)

;;pairwise disjoint sets
(comment)
