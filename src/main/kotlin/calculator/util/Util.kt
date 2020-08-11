package calculator.util

fun Int.isOdd() = this % 2 != 0

/**
 * 주어진 인자로 시작하고 나머지는 index 이후의 subList로 구성된 리스트를 새로 반환한다.
 */
fun <T> List<T>.subListStartWith(node: T, index: Int): List<T> {
    return mutableListOf(node).apply {
        addAll(this@subListStartWith.subListAfter(index))
    }
}

/**
 * index 이후의 subList로 구성된 리스트를 반환
 */
fun <T> List<T>.subListAfter(index: Int): List<T> {
    return if (index < size) subList(index, size) else listOf()
}
