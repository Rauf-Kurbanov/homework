let evenNum1 list =
    List.length (List.filter (fun x -> x % 2 = 0) list)

let evenNum2 list =
    List.sum (List.map (fun x -> (x + 1) % 2) list)

let evenNum3 list =
    List.fold (fun acc x -> acc + 1 - x % 2) 0 list

let list = [1; 2; 3; 4; 6; 8; 0; 32]

printf "%d\n" (evenNum1 list)
printf "%d\n" (evenNum2 list)
printf "%d\n" (evenNum3 list)