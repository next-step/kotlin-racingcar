package racingcar.view.component

import racingcar.domain.RoundResult
import racingcar.view.ui.Br

class RoundResultComponent(
    private val roundResult: RoundResult,
) : Component {
    override fun render() {
        roundResult.carPositions.forEach { carPosition ->
            CarNameComponent(name = carPosition.name.value).render()
            DistanceComponent(position = carPosition.position).render()
            Br().draw()
        }
    }
}
