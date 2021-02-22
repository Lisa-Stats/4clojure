(ns fourclojure.elementary.main)

;;nothing but the truth
(comment
  true)

;;simple math
(comment
  4)

;;intro to strings
(comment
  "HELLO WORLD")

;;intro to lists
(comment
  (= (list :a :b :c) '(:a :b :c)))

;;lists: conj
(comment
  (conj '(2 3 4) 1)
  (conj '(3 4) 1 2)
  '(1 2 3 4))

;;intro to vectors
(comment
  :a :b :c)

;;vectors: conj
(comment
  [1 2 3 4])

;;intro to sets
(comment
  #{:a :b :c :d})

;;into to conj
(comment
  2)

;;intro to maps
(comment
  20)

;;maps: conj
(comment
  [:b 2])

;;intro to sequences
(comment
  3)

;;sequences: rest
(comment
  [20 30 40])

;;intro to functions
(comment
  8)

;;double down
(comment
  * 2)

;;hello world
(comment
  (def nameone (fn [name] (str "Hello, " name "!")))
  (nameone "sam")
  ;;ans = (fn [x] (str "Hello, "x"!"))
  )

;;sequences: map
(comment
  '(6 7 8))

;;sequences: filter
(comment
  '(6 7))

;;local bindings
(comment
  7)

;;let it be
(comment
  (let [x 2 y 1] (+ x y))
  ;;ans [x 7 y 3 z 1]
  )

;;regular expressions
(comment
  (re-seq #"[A-Z]" "bA1B3Ce")
  "ABC")

;;intro to reduce
(comment
  +)

;;simple recursion
(comment
  '(5 4 3 2 1))

;;rearranging code: ->
(comment
  (-> [2 5 4 1 3 6]
      (reverse) (rest) (sort) (last))
  ;;ans = last
  )

;;recurring theme
(comment
  '(7 6 5 4 3))

;;rearranging code: ->>
(comment
  (->> [2 5 4 1 3 6]
       (drop 2)
       (take 3)
       (map inc)
       (apply +))
  ;;ans = apply +
  )

;;for the win
(comment
  '(1 5 9 13 17 21 25 29 33 37))

;;logical falsity and truth
(comment
  1)

;;intro to destructuring
(comment
  ;;[c e]
  )

;;subset and superset
(comment
  #{1 2})

;;a nil key
(comment
  (fn [k m]
    (and (contains? m k)
         (= nil (get m k)))))

;;map defaults
(comment
  (fn [default ks] (zipmap ks (repeat default))))