import Foundation

func solution(_ my_string:String) -> String {
    var result = my_string
    result = result.replacingOccurrences(of: "a", with: "")
    result = result.replacingOccurrences(of: "e", with: "")
    result = result.replacingOccurrences(of: "i", with: "")
    result = result.replacingOccurrences(of: "o", with: "")
    result = result.replacingOccurrences(of: "u", with: "")
    
    return result
}