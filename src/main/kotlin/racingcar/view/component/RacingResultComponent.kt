package racingcar.view.component

import racingcar.view.container.RoundListContainer
import racingcar.view.container.WinnerContainer

class RacingResultComponent : Component {
    override fun render() {
        RoundListContainer().render()
        WinnerContainer().render()
    }
}
