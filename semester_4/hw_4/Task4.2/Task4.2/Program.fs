//Записать в point-free стиле func x l = List.map (fun y -> y * x) l

let f1 x l = List.map (fun y -> y * x) l

let f2 x = List.map ((*) x)

let f3 : int -> int list -> int list = List.map << (*)

printfn "%A" (f3 2 [1..10])