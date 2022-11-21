package racingcar.view.component

import racingcar.view.ui.Span

class CarNameComponent(
    private val name: String,
) : Component {
    override fun render() {
        Span(text = "${this.name} : ").draw()
    }
}
