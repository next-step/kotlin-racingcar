package step3.racingcar.domain

class Cars private constructor(private val elements: List<Car>) {
    fun elements(): List<Car> = elements

    fun size(): Int = elements.size

    operator fun get(index: Int): Car = elements[index]

    fun winnerNames(): String =
        findWinnerNames().joinToString(WINNER_NAME_JOINING_SEPARATOR)

    private fun findWinnerNames(): List<String> =
        elements()
            .filter { it.distance == findMaxDistance() }
            .map { it.name }

    private fun findMaxDistance(): Int = elements().maxOf { it.distance }

    companion object {
        private const val WINNER_NAME_JOINING_SEPARATOR = ", "
        fun of(elements: List<Car>): Cars = Cars(elements)
    }
}
