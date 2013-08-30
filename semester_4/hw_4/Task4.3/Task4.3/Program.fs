open System.IO
open System.Text

let help() = 
    printfn "Enter the command:
            0 - Exit
            1 - Add record
            2 - Find number
            3 - Find name
            4 - Save data
            5 - Read data"

let addNewRecord name number data =
    let data = (name, number) :: data
    data
    
let findNameByNumber number (data) =
    let data = List.filter (fun x -> snd x = number) data
    List.map (fun x -> printfn "%s\n" (fst x)) data |> ignore
    
let findNumberByName name (data) =
    let data = List.filter (fun x -> fst x = name) data
    List.map (fun x -> printfn "%s\n" (snd x)) data |> ignore
    
let writeToFile path (str : string) =
    try
        use file = File.CreateText path
        file.WriteLine str
    with
    | exn -> printfn "Error %s" exn.Message

let readData path (data) = 
    try
        use reader = File.OpenText path
        let output = reader.ReadLine()
        printf "%s" output
    with
    | exn -> printfn "Error %s" exn.Message
    
let saveData (path : string) data =
    writeToFile path (data.ToString())

let rec start data = 
    help()
    let cmd = System.Console.ReadLine()
        
    match cmd with
    | "0" -> exit 0
    | "1" ->
        printfn "%s" "\nEnter name"
        let name = System.Console.ReadLine()
        printfn "%s" "\nEnter phone number"
        let number = System.Console.ReadLine()
        start (addNewRecord name number data)
    | "2" ->
        printfn "%s" "\nEnter name to find"
        findNumberByName(System.Console.ReadLine()) data
        start data
    | "3" ->
        printfn "%s" "\nEnter number to find"
        findNameByNumber(System.Console.ReadLine()) data
        start data
    | "4" ->
        printfn "%s" "\nData has been saved" 
        saveData "phoneBook.txt" data
        start data
    | "5" ->
        printfn "%s" "\nOpening file"  
        readData "phoneBook.txt" data
        start data
    | _ -> 
        printfn "%s" "\nInvalid input. Please try again"
        start data

let inputData = []
start inputData