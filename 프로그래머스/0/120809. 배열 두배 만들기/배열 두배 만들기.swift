import Foundation

func solution(_ numbers:[Int]) -> [Int] {
    var arr : [Int] = [Int]()
    
    for item in numbers {
        arr.append(item * 2)
    }
    
    return arr
}