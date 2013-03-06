let firstEntry list n =
    let rec loop list n depth =
        if List.isEmpty list then 0 else
            if (n = List.head list) then depth
                else loop(List.tail list) n (depth + 1)
    loop list n 1
printf "%d \n" (firstEntry[1; 2; 3] 2)