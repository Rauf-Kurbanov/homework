let min2 (a, b) = if (a < b) then a else b
let min list = List.fold (fun acc x -> min2(acc, x)) (List.head list) list
printf "%d" (min [9; 1; 2; 3])