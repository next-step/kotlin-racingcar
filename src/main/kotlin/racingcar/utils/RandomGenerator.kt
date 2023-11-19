package racingcar.utils

class RandomGenerator(
    private val min: Int,
    private val max: Int,
) {
    fun generate(): Int {
        return (min..max).random()
    }
}
