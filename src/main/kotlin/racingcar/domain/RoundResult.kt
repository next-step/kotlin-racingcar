package racingcar.domain

class RoundResult(
    private val positionsByCarOrder: MutableMap<Int, Int>
) {
    companion object {
        fun createInitialResult(configuration: RoundResultConfiguration): RoundResult {
            val positionsByCarOrder = mutableMapOf<Int, Int>()
            configuration.cars.forEach { positionsByCarOrder[it.order] = it.position }
            return RoundResult(positionsByCarOrder = positionsByCarOrder)
        }
    }
}
