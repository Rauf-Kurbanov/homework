let rec hasAnyPair list =
    match list with
    | [] -> false
    | head :: tail -> List.exists (fun x -> x = head) tail || hasAnyPair tail

let isUnicList list = not (hasAnyPair list) 

printf "%b\n" (isUnicList [1; 2; 3; 4; 5])
printf "%b\n" (isUnicList [1; 2; 3; 4; 5; 3])