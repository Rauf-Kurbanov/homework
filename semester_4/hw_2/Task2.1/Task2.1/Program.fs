let reverse list =
    let rec loop list result =
        match list with
        | head :: tail ->
            let result = head :: result
            loop list.Tail result
        | [] -> result
    loop list []
printfn "%A \n" (reverse [1 .. 10])
