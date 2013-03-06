let rec isPal str =
    let l = String.length str
    match l with
    | 0 | 1 -> true
    | _ -> if (str.[0] = str.[l - 1]) then isPal(str.[1..l - 2]) else false 
System.Console.WriteLine(isPal("argentinamanitnegra"))