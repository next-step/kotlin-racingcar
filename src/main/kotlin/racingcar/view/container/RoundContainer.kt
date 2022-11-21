package racingcar.view.container

import racingcar.domain.Round
import racingcar.view.component.RoundOrderComponent
import racingcar.view.store.CarGroupStore
import racingcar.view.ui.Br

class RoundContainer(private val round: Round) : Container {
    private fun roundStart() {
        val carGroup = CarGroupStore.getState()
        this.round.start(carGroup = carGroup)
        CarGroupStore.setState(state = carGroup)
    }
    override fun render() {
        this.roundStart()
        RoundOrderComponent(id = round.id).render()
        CarPositionContainer().render()
        Br().draw()
        Thread.sleep(1000)
    }
}
