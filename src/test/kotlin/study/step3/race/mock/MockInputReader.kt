package study.step3.race.mock

class MockInputReader(
    private val inputs: List<String>,
) : InputReader {

    private var index = 0

    override fun raedLine(): String? = if (index < inputs.size) inputs[index++] else null
}
