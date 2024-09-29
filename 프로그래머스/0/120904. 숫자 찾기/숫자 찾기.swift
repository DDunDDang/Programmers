import Foundation

func solution(_ num: Int, _ k: Int) -> Int {
    let numString = String(num)
    let kString = String(k)
    
    if let index = numString.firstIndex(of: kString.first!) {
        return numString.distance(from: numString.startIndex, to: index) + 1
    }
    
    return -1
}