import Foundation

func solution(_ numer1:Int, _ denom1:Int, _ numer2:Int, _ denom2:Int) -> [Int] {
    var denom = denom1 * denom2
    var numer = (numer1 * denom2) + (numer2 * denom1)
    
    var divisor = gcd(numer, denom)
    
    return [numer / divisor, denom / divisor]
}

func gcd(_ a: Int, _ b: Int) -> Int {
    var r = a % b
    if r != 0 {
        return gcd(b, r)
    } else {
        return b
    }
}