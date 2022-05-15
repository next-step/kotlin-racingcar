package game.racingcar.util

inline fun <T : Any> List<T>.requireOrThrow(
    message: String = "목록에 유효하지 않는 항목이 포함되어 있습니다.",
    predicate: (T) -> Boolean
): List<T> {
    for (element in this) {
        require(predicate(element)) { message }
    }
    return this
}
