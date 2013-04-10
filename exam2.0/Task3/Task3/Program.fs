type Stack<'a>() =
    let mutable list : 'a list = []
    member v.Push h = list <- h :: list

    member v.Pop = if v.Length = 0 then failwith "Stack is empty" 
                   let r = list |> List.head
                   list <- list |> List.tail
                   r
    member v.Peek = list |> List.head
    member v.Length = list.Length
    member v.isEmpty = v.Length <= 0

let stack = new Stack<int>()
stack.Push(1)
printfn "%d" stack.Peek
stack.Push(4)
stack.Push(5)
printfn "%d" stack.Pop
printfn "%d" stack.Pop