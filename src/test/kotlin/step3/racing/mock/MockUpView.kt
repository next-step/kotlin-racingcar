package step3.racing.mock

class MockUpView : View {
    private val buffer = StringBuffer()
    override fun input(message: String?) = "3"

    override fun print(message: String) {
        buffer.append("$message\n")
    }

    override fun toString() = buffer.toString()
}
