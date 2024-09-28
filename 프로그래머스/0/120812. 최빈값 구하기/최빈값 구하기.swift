import Foundation

func solution(_ array: [Int]) -> Int {
    guard !array.isEmpty else { return -1 }
    if array.count == 1 { return array[0] }
    
    let sortedArray = array.sorted()
    var currentNum = sortedArray[0]
    var currentCount = 1
    var maxCount = 1
    var mode = currentNum
    var hasDuplicateMode = false
    
    for i in 1..<sortedArray.count {
        if sortedArray[i] == currentNum {
            currentCount += 1
        } else {
            if currentCount > maxCount {
                maxCount = currentCount
                mode = currentNum
                hasDuplicateMode = false
            } else if currentCount == maxCount {
                hasDuplicateMode = true
            }
            currentNum = sortedArray[i]
            currentCount = 1
        }
    }
    
    if currentCount > maxCount {
        mode = currentNum
        hasDuplicateMode = false
    } else if currentCount == maxCount {
        hasDuplicateMode = true
    }
    
    return hasDuplicateMode ? -1 : mode
}