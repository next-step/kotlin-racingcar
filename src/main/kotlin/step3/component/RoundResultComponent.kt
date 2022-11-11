package step3.component

import step3.RoundResult

class RoundResultComponent(
    private val roundResult: RoundResult,
) : Component {
    override fun render() {
        roundResult.carPositions.forEach { carPosition ->
            DistanceComponent(position = carPosition.position).render()
            println()
        }
    }
}
