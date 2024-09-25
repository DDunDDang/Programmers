import Foundation

func solution(_ money:Int) -> [Int] {
    var result : [Int] = [Int]()
    result.append(money / 5500)
    result.append(money % 5500)
    
    return result
}