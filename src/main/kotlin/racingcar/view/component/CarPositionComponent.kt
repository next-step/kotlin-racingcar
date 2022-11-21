package racingcar.view.component

import racingcar.domain.CarPosition
import racingcar.view.ui.Br

class CarPositionComponent(private val carPositions: List<CarPosition>) : Component {
    override fun render() {
        this.carPositions.forEach { carPosition ->
            CarNameComponent(name = carPosition.name.value).render()
            DistanceComponent(position = carPosition.position).render()
            Br().draw()
        }
    }
}
