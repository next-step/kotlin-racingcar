package racingcar.component

import racingcar.Position
import racingcar.ui.Span

class DistanceComponent(
    private val position: Position,
) : Component {
    override fun render() {
        repeat(position.value) { Span(text = "-").draw() }
    }
}
