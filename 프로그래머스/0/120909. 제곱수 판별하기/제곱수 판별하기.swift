import Foundation

func solution(_ n: Int) -> Int {
    let num = Int(sqrt(Double(n)))
    return num * num == n ? 1 : 2
}