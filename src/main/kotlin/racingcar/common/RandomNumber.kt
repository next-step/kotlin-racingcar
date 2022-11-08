package racingcar.common

class RandomNumber(private val range: IntRange) {

    fun generate() = range.random()

}
