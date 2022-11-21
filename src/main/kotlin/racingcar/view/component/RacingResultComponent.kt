package racingcar.view.component

import racingcar.view.container.RoundContainer
import racingcar.view.container.WinnerContainer

class RacingResultComponent : Component {
    override fun render() {
        RoundContainer().render()
        WinnerContainer().render()
    }
}
