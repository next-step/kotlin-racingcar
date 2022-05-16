package racingcar.car

object RandomList {
    fun intListBy(range: IntRange, size: Int): List<Int> {
        return List(size) { range.random() }
    }
}