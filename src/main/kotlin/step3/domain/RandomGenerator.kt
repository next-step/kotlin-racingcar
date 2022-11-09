package step3.domain

interface RandomGenerator {
    val candidates: List<Int>
    fun getRandomNumber(): Int
    fun getRandomValidation(): Boolean
}
