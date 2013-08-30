let explode (s:string) = [for c in s -> c]
let checkBracket (str : string) =
    let rec loop str list =
        match str with
        | [] -> true
        | h :: t -> match h with    
                    | '(' | '[' | '{' -> loop t (str.[0] :: list)
                    | ')' -> if (list.Head <> '(') then false else loop t list.Tail
                    | ']' -> if (list.Head <> '[') then false else loop t list.Tail
                    | '}' -> if (list.Head <> '{') then false else loop t list.Tail
                    | _ -> loop t list
    let list = ['0']
    loop (explode str) list

printf "%b\n" (checkBracket "ааааа[({)}]а")
printf "%b\n" (checkBracket "bite( [{} [] m]e)")