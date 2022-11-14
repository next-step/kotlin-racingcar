package step3.component

import step3.Position
import step3.ui.Span

class DistanceComponent(
    private val position: Position,
) : Component {
    override fun render() {
        repeat(position.value) { Span(text = "-").draw() }
    }
}
