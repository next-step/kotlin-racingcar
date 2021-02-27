package calculator

class MockInput(private val line: String) : Input {
    override fun read(): String {
        return line
    }
}
