//open System.Collections.Generic

type FakeStack<char> (list : list<char>) =
    member s.Push t = t :: list
    member s.Pop = let r = list.Head
                   let list = list.Tail
                   r
    member s.Count = list.Length

    new() = FakeStack([0])


let explode (s:string) = [for c in s -> c]
let checkBracket (str : string) =
    let stack = new FakeStack<char>()
    //stack.Push('0')
    let rec loop str =
        match str with
        | [] -> true
        | h :: t -> match h with    
                    | '(' | '[' | '{' -> stack.Push(str.[0])
                                         loop(t)
                    | ')' -> if (stack.Pop() <> '(') then false else loop(t)
                    | ']' -> if (stack.Pop() <> '[') then false else loop(t)
                    | '}' -> if (stack.Pop() <> '{') then false else loop(t)
                    | _ -> loop(t)
    loop (explode str)

printf "%b\n" (checkBracket "ааааа[({)}]а")
printf "%b\n" (checkBracket "bite( [{} [] m]e)")