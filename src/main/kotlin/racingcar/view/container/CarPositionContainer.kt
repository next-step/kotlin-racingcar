package racingcar.view.container

import racingcar.view.component.CarPositionComponent
import racingcar.view.store.CarGroupStore

class CarPositionContainer : Container {
    override fun render() {
        val carGroup = CarGroupStore.getState()
        val carPositions = carGroup.getPositions()
        CarPositionComponent(carPositions = carPositions).render()
    }
}
