package study.racinggame.service.mock

import study.racinggame.service.reader.InputReader

class MockInputReader(
    private val inputs: List<String>
) : InputReader {

    private var index = 0

    override fun raedLine(): String = if (index < inputs.size) inputs[index++] else ""
}
