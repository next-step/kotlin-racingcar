package step3.component

import step3.RoundResult
import step3.ui.Span

class RoundResultComponent(
    private val roundResult: RoundResult,
) : Component {
    override fun render() {
        roundResult.carPositions.forEach { carPosition ->
            Span(text = "자동차 ${carPosition.id}: ").draw()
            DistanceComponent(position = carPosition.position).render()
            println()
        }
    }
}
