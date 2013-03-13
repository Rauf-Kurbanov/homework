type Tree<'a> =
    | Tree of 'a * Tree<'a> * Tree<'a>
    | Leaf of 'a

let rec height tree =
    match tree with
    | Tree(x, left, right) -> 1 + max (height left) (height right)
    | Leaf x -> 1

let t = Tree(5, Tree(1, Leaf(2), Leaf(3)), Leaf(5))
printf "%d\n" (height t)