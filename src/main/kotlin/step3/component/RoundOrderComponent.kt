package step3.component

import step3.ui.Span

class RoundOrderComponent(
    private val id: Int,
) : Component {
    override fun render() {
        Span(text = "$id 라운드", block = true)
    }
}
