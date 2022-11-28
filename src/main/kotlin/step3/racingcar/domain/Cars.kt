package step3.racingcar.domain

class Cars private constructor(private val elements: List<Car>) {
    val winnerNames: String = formatToWinnerNames()

    fun elements(): List<Car> = elements

    fun size(): Int = elements.size

    operator fun get(index: Int) = elements[index]

    private fun formatToWinnerNames(): String =
        findWinnerNames().joinToString(WINNER_NAME_JOINING_SEPARATOR)

    private fun findWinnerNames() =
        elements()
            .filter { it.distance == findMaxDistance() }
            .map { it.name }

    private fun findMaxDistance() = elements().maxOf { it.distance }

    companion object {
        private const val WINNER_NAME_JOINING_SEPARATOR = ", "
        fun of(elements: List<Car>) = Cars(elements)
    }
}
