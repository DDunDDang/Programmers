import Foundation

func solution(_ n:Int) -> Int {
    var remain = n % 7 == 0 ? 0 : 1
    return n / 7 + remain
}