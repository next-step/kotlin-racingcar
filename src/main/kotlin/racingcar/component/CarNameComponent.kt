package racingcar.component

import racingcar.ui.Span

class CarNameComponent(
    private val name: String,
) : Component {
    override fun render() {
        Span(text = "$name : ").draw()
    }
}
