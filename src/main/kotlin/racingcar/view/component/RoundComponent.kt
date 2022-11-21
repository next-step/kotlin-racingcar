package racingcar.view.component

import racingcar.domain.Round
import racingcar.view.container.CarPositionContainer
import racingcar.view.store.CarGroupStore
import racingcar.view.ui.Br

class RoundComponent(private val round: Round) : Component {

    private fun roundStart() {
        val carGroup = CarGroupStore.getState()
        round.start(carGroup = carGroup)
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
