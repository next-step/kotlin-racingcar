package racingcar.view.component

import racingcar.domain.Round
import racingcar.domain.RoundResult
import racingcar.view.container.CarPositionContainer
import racingcar.view.store.CarGroupStore
import racingcar.view.ui.Br

class RoundComponent(private val round: Round) : Component {

    private fun roundStart(): RoundResult {
        val carGroup = CarGroupStore.getState()
        val roundResult = round.start(carGroup = carGroup)
        CarGroupStore.setState(state = carGroup)
        return roundResult
    }

    override fun render() {
        val roundResult = this.roundStart()
        RoundOrderComponent(id = round.id).render()
        CarPositionContainer().render()
        Br().draw()
        Thread.sleep(1000)
    }
}
