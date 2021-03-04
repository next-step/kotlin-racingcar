package racingcar.domain

data class Round(var value: Int) : Iterable<Int> {
    override fun iterator() = (0 until value).iterator()
}
