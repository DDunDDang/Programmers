import Foundation

func solution(_ number:Int, _ n:Int, _ m:Int) -> Int {
    
    var divisor = gcd(n, m)
    
    return number % (n * m / divisor) == 0 ? 1 : 0
}

func gcd(_ a: Int, _ b: Int) -> Int {
    var r = a % b
    if r != 0 {
        return gcd(b, r)
    } else {
        return b
    }
}