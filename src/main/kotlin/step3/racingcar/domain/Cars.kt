package step3.racingcar.domain

class Cars private constructor(private val elements: List<Car>) {
    fun size(): Int = elements.size

    operator fun get(index: Int): Car = elements[index]

    fun race(numberGenerator: NumberGenerator): RoundResult {
        val roundResult = RoundResult()
        elements.forEach {
            it.race(numberGenerator.value())
            roundResult.add(it)
        }
        return roundResult
    }

    fun winnerNames(): List<String> {
        val maxDistance = findMaxDistance()
        return elements
            .filter { it.isMaximumDistance(maxDistance) }
            .map { it.name }
    }

    private fun findMaxDistance(): Int = elements.maxOf { it.distance }

    companion object {
        fun of(elements: List<Car>): Cars = Cars(elements)
    }
}
