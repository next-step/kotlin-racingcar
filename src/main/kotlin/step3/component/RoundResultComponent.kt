package step3.component

import step3.RoundResult
import step3.ui.Br

class RoundResultComponent(
    private val roundResult: RoundResult,
) : Component {
    override fun render() {
        roundResult.carPositions.forEach { carPosition ->
            CarNameComponent(name = carPosition.name).render()
            DistanceComponent(position = carPosition.position).render()
            Br().draw()
        }
    }
}
