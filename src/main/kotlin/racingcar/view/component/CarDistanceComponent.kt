package racingcar.view.component

import racingcar.domain.Position
import racingcar.view.ui.Span

class CarDistanceComponent(
    private val position: Position,
) : Component {
    override fun render() {
        repeat(this.position.value) { Span(text = "-").draw() }
    }
}
