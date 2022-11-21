package racingcar.view.component

import racingcar.view.ui.Span

class RoundOrderComponent(
    private val id: Int,
) : Component {
    override fun render() {
        Span(text = "${this.id} 라운드", block = true)
    }
}
