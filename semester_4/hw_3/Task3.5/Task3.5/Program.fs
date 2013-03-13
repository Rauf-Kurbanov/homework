type ParseTree<'op, 'dg> =
    | ParseTree of 'op * ParseTree<'op, 'dg> * ParseTree<'op, 'dg>
    | Leaf of 'dg

let rec calculate tree =
    match tree with
    | ParseTree(op, l, r) ->
        match op with
        | '+' -> calculate l + calculate r
        | '-' -> calculate l - calculate r
        | '*' -> calculate l * calculate r
        | '/' -> calculate l / calculate r
    | Leaf dg -> dg

let t = ParseTree('+', ParseTree('*', Leaf(2), Leaf(2)), Leaf(2))
printf "%d\n" (calculate t)