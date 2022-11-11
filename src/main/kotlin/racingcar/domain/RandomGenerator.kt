package racingcar.domain

interface RandomGenerator {
    val candidates: List<Int>
    fun getRandomNumber(): Int
    fun getRandomValidation(): Boolean
}
