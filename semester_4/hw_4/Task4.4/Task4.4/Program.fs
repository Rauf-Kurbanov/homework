type Expr =
    | X
    | Const of float
    | Add of Expr * Expr
    | Sub of Expr * Expr
    | Mult of Expr * Expr
    | Div of Expr * Expr
   
let (|Oper|_|) (expr : Expr) =
    match expr with
    | Add(e1, e2) -> Some(Add, e1, e2)
    | Sub(e1, e2) -> Some(Sub, e1, e2)
    | Mult(e1, e2) -> Some(Mult, e1, e2)
    | Div(e1, e2) -> Some(Div, e1, e2)
    | _ -> None

let rec simplifyExpr (expr : Expr) =
    match expr with
    | Add(Const(n1), Const(n2)) -> Const(n1 + n2)
    | Sub(Const(n1), Const(n2)) -> Const(n1 - n2)
    | Mult(Const(n1), Const(n2)) -> Const(n1 * n2)
    | Div(Const(n1), Const(n2)) -> Const(n1 / n2)
    | Add(x, Const(0.0)) -> x |> simplifyExpr
    | Add(Const(0.0), x) -> x |> simplifyExpr
    | Add(Const(n), x) -> Add(x, Const(n)) |> simplifyExpr
    | Sub(x, Const(0.0)) -> x |> simplifyExpr
    | Sub(x, y) when x = y -> Const(0.)
    | Mult(x, Const(1.0)) -> x |> simplifyExpr
    | Mult(Const(1.0), x) -> x |> simplifyExpr
    | Mult(x, Const(0.0)) -> Const(0.)
    | Mult(Const(0.0), x) -> Const(0.)
    | Mult(x, Const(n)) -> Mult(Const(n), x) |> simplifyExpr
    | Mult(Div(Const(n), x1), x2) -> Mult(Const(n), Div(x2, x1)) |> simplifyExpr
    | Mult(x1, Div(Const(n), x2)) -> Mult(Const(n), Div(x1, x2)) |> simplifyExpr
    | Div(Const(0.0), x) -> Const(0.0)
    | Div(x, Const(1.)) -> x |> simplifyExpr
    | Oper (oper, x1, x2) -> oper(simplifyExpr x1, simplifyExpr x2) |> simplifyExpr
    | _ -> expr

let rec derivative (expr : Expr) =
    let der =
        match expr with
        | X -> Const(1.)
        | Const(n) -> Const(0.0)
        | Add(x1, x2) -> Add(derivative x1, derivative x2)
        | Sub(x1, x2) -> Sub(derivative x1, derivative x2)
        | Mult(x1, x2) -> Add(Mult(derivative x1, x2), Mult(x1, derivative x2))
        | Div(x1, x2) -> Div(Sub(Mult(derivative x1, x2), Mult(x1, derivative x2)), Mult(x2, x2))
    simplifyExpr der

let Expr01 = Add(Mult(Const(1.), Const(2.)), Mult(Const(3.), X))
let Expr02 = Mult(X, Const(2.))

Expr01 |> printfn "%A" 
Expr01 |> derivative |> printfn "%A" 

Expr02 |> printfn "%A" 
Expr02 |> derivative |> printfn "%A" 