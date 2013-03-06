let fact1 n =
    let rec loop i acc =
        match i with
        | 0 | 1 -> acc
        | _ -> loop (i - 1) (acc * i)
    loop n 1
printf "%d \n" (fact1 5)

let fact2 n = [1..n] |> List.fold (*) 1
printf "%d \n" (fact2 5)

let fact3 n = [1..n] |> List.reduce (*)
printf "%d \n" (fact3 5)