open System.IO
open System.Collections.Generic
open System.Text
open System

let help() = 
    printfn "Enter the command:
            0 - Exit
            1 - Add record
            2 - Find number
            3 - Find name
            4 - Save data
            5 - Read data"

type Command =
    | Exit = 0
    | Add = 1
    | FindNum = 2
    | FindName = 3
    | Save = 4
    | Read = 5

type PhoneBook() =
    member this.addNewRecord name number (currentData : Dictionary<string, string>) =
        if (not (currentData.ContainsKey number)) then 
            currentData.Add(number, name) 
    
    member this.findNameByNumber number (currentData : Dictionary<string, string>) =
        if currentData.ContainsKey number then
            printfn "%s" currentData.[number]
    
    member this.findNumberByName name (currentData : Dictionary<string, string>) =
        if currentData.ContainsValue(name) then
            for pair in currentData do
                if pair.Value.Equals name then
                    printfn "%s" pair.Key
    
    member this.writeToFile path (str : string) =
        try
            use file = File.CreateText path
            file.WriteLine str
        with
        | exn -> printfn "Error %s" exn.Message

    member this.readData path (currentData : Dictionary<string, string>) = 
        try
            use reader = File.OpenText path
            let rec readLines() =
                let line1 = reader.ReadLine()
                let line2 = reader.ReadLine()
                match line1 with
                | null | ""  -> ()
                | _ ->
                    this.addNewRecord line1 line2 currentData
                    readLines() 
            readLines()
        with
        | exn -> printfn "Error %s" exn.Message
    
    member this.saveData path (currentData : Dictionary<string, string>) =
        let data = new StringBuilder()
        let append (str : string) = data.Append str |> ignore
        for pair in currentData do
            append(pair.Value + "\n" + pair.Key + "\n")   
        this.writeToFile path (data.ToString())

let rec start() data (book : PhoneBook) = 
    help()
    let cmd = System.Console.ReadLine()
        
    match cmd with
    | "0" -> exit 0
    | "1" ->
        printfn "%s" "\nEnter name"
        let name = System.Console.ReadLine()
        printfn "%s" "\nEnter phone number"
        let number = System.Console.ReadLine()
        book.addNewRecord name number data
        start() data book
    | "2" ->
        printfn "%s" "\nEnter name to find"
        book.findNumberByName(Console.ReadLine()) data
        start() data book
    | "3" ->
        printfn "%s" "\nEnter number to find"
        book.findNameByNumber(Console.ReadLine()) data
        start() data book
    | "4" ->
        printfn "%s" "\nData has been saved" 
        book.saveData "phoneBook.txt" data
        start() data book
    | "5" ->
        printfn "%s" "\nOpening file"  
        book.readData "phoneBook.txt" data
        start() data book
    | _ -> 
        printfn "%s" "\nInvalid input. Please try again"
        start() data book


let inputData = new Dictionary<string, string>()
let inputBook = new PhoneBook()

start() inputData inputBook