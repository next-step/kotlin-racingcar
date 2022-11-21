package racingcar.view.component

import racingcar.domain.Position
import racingcar.view.ui.Span

class DistanceComponent(
    private val position: Position,
) : Component {
    override fun render() {
        repeat(position.value) { Span(text = "-").draw() }
    }
}
