package step3.racingcar.domain

import step3.racingcar.view.ResultView

class Cars private constructor(val elements: List<Car>) {
    fun elements(): List<Car> = elements

    fun size(): Int = elements.size

    operator fun get(index: Int): Car = elements[index]

    fun race(currentRoundIndex: Int, randomNumber: RandomNumber) {
        elements.forEach {
            it.race(randomNumber.value())
        }
        ResultView.printRoundResult(currentRoundIndex, this)
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
