let maxPair list =
    let list = List.zip (0 :: list) (list @ [0])
    let list = List.map (fun (a, b) -> a + b) list
    List.findIndex((=) (List.max list)) list 

let list = [1; 5; 6; 2; 6; 9; 0; 60]
printf "%d\n" (maxPair list)