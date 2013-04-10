let rhomb n =
    let rec rhombl n length step =
        let lst = [ for i in 1 .. (2 * n - 1) -> if (i <= (n - length) || i >= (n + length)) then ' ' else '*' ]
        printfn "%s" (System.String.Concat(Array.ofList(lst)))
        if (step < 2*n) then
            if (step < n) then (rhombl n (length + 1) (step + 1)) else (rhombl n (length - 1) (step + 1))
    rhombl n 0 0
rhomb 6