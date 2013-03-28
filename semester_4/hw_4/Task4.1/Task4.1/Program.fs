open System.Collections.Generic

let explode (s:string) = [for c in s -> c]
let checkBracket (str : string) =
    let stack = new Stack<char>()
    stack.Push('0')
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