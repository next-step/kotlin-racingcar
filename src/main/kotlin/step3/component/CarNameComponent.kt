package step3.component

import step3.ui.Span

class CarNameComponent(
    private val name: String,
) : Component {
    override fun render() {
        Span(text = "$name : ").draw()
    }
}
