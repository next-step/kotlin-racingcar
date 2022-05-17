package racingcar.car

object RandomList {
    fun intListBy(range: IntRange, size: Int): List<Int> = List(size) { range.random() }
}
