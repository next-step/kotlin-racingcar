package racingcar.domain

class RandomGenerator(private val from: Int, private val to: Int) {

    fun makeRandomValue(): Int {
        return (from..to).random()
    }
}
