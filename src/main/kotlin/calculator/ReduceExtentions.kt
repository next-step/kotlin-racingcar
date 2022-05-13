package calculator

inline fun Sequence<MatchResult>.reduce(operation: (acc: Int, operator: String, value: Int) -> Int): Int {
    var accumulator = 0

    for (element in this) {
        accumulator = if (element.groupValues[1].isNotEmpty())
            element.groupValues[1].toInt()
        else accumulator

        accumulator = operation(accumulator, element.groupValues[2], element.groupValues[3].toInt())
    }
    return accumulator
}
