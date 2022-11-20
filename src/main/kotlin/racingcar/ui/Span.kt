package racingcar.ui

class Span(
    private val text: String,
    private val block: Boolean = false,
) : UI {
    override fun draw() {
        if (block) {
            println(text)
            return
        }
        print(text)
    }
}
