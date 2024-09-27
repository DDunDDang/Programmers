import Foundation

func solution(_ hp:Int) -> Int {
    let attacks = [5, 3, 1]
    var currentHp = hp
    var result = 0
    
    for attack in attacks {
        result += currentHp / attack
        currentHp %= attack
    }

    return result
}