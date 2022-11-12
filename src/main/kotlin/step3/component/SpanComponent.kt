package step3.component

class SpanComponent(
    val text: String,
) : Component {
    override fun render() {
        print(text)
    }
}
