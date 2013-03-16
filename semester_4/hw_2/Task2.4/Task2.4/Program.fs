let firstEntry list n =
    let rec loop list n depth =
        if List.isEmpty list then None else
            if (n = List.head list) then Some(depth)
                else loop(List.tail list) n (depth + 1)
    loop list n 1
printf "%A \n" (firstEntry[1; 2; 3] 2)
printf "%A \n" (firstEntry[1; 2; 3] 0)