type RoundingBuilder(precision : int) =

    member this.Bind (x : float, rest : float -> float) =
        System.Math.Round(rest x, precision)

    member this.Return x = x

let rounding precision = RoundingBuilder precision

let res precision =
    rounding precision {
            let! a = 2.0 / 12.0
            let! b = 3.5
            return a / b
        } 

printfn "%A" (res 3)
printfn "%A" (res 10)