let fib1 n =
    let rec loop n acc1 acc2 = 
        if n > 1 then loop (n - 1) acc2 (acc1 + acc2)  else acc1 + acc2
    loop n 0 1
printf "%d \n" (fib1 10)

let fib2 n =
    let fibSeq = 
        Seq.unfold (fun (a,b) -> Some( a+b, (b, a+b) ) ) (0, 1)
    match n with
    | 1 | 2 -> 1
    | _ -> fibSeq |> Seq.nth (n - 1)
printf "%d \n" (fib2 10)