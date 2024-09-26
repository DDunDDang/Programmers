import Foundation

func solution(_ my_strings:[String], _ parts:[[Int]]) -> String {
    var result = ""
    
    for (idx, part) in parts.enumerated() {
        let startIndex = my_strings[idx].index(my_strings[idx].startIndex, offsetBy: part[0])
        let endIndex = my_strings[idx].index(my_strings[idx].startIndex, offsetBy: part[1])
        result += String(my_strings[idx][startIndex...endIndex])
    }
    
    return result
}