package carracing.domain

fun interface Threshold {
    fun isSatisfied(value: Int): Boolean
}
