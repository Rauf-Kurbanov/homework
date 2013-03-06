let isPrime (n : bigint) =
    seq { bigint(2) .. bigint(sqrt(float n))}
        |> Seq.exists (fun x -> n % x = bigint(0)) 
        |> not

let primes =
    Seq.initInfinite (fun i -> i + 2)
    |> Seq.map (fun i -> bigint(i))
    |> Seq.filter isPrime

printfn "%A" primes