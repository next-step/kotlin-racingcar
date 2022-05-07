/**
 *  Kotlin reduce 로직을 베이스로 작성되었습니다.
 *
 * accumulator 초기값은 0 입니다.
 * [1] MatchResult 첫번째 연산은 x + y : x 값이 "" 빈 문자열이 아니기 때문에 accumulator 을 x + y 의 결과 값으로 설정됩니다.
 * [2] 두번째 연산 부터 "" + y : 선행된 연산 값이 있기 때문에 1번의 결과값이 accumulator 으로 설정됩니다.
 *
 */
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
