package step3.component

import step3.RoundResult

class RoundResultComponent(
    private val roundResult: RoundResult,
) : Component {
    override fun render() {
        roundResult.carPositions.forEach { carPosition ->
            SpanComponent(text = "자동차 ${carPosition.id}: ").render()
            DistanceComponent(position = carPosition.position).render()
            println()
        }
    }
}
