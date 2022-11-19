package racingcar.component

import racingcar.RoundResult
import racingcar.ui.Br

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
