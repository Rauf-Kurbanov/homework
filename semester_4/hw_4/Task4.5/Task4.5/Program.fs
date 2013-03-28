type Tree<'a> =
    | Tree of 'a * Tree<'a> * Tree<'a>
    | Tip of 'a

    member t.map f =
        match t with
        | Tree(value, l, r) -> Tree(f value, l.map f, r.map f)
        | Tip(value) -> Tip(f value)

let testTree = Tree(1, Tree(2, Tip(7), Tip(8)), Tip(3))
printf "%A\n" testTree
printf "%A\n" (testTree.map (fun x -> x * 10))