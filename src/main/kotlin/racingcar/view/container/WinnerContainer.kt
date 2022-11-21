package racingcar.view.container

import racingcar.view.component.WinnerComponent
import racingcar.view.store.CarGroupStore

class WinnerContainer : Container {

    override fun render() {
        val carGroup = CarGroupStore.getState()
        val winners = carGroup.getWinners()
        WinnerComponent(winners = winners).render()
    }
}
