package step2

fun <T> headWithRest(list: List<T>): Pair<T, List<T>> {
    val head = list.first()
    val rest = list.drop(1)
    return Pair(head, rest)
}
