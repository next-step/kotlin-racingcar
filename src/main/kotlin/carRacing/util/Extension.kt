package carRacing.util

inline fun <T, R : Comparable<R>> Iterable<T>.maxAllBy(selector: (T) -> R): List<T> {
    val max: R = this.maxOf(selector)
    return this.filter { selector(it) == max }
}
