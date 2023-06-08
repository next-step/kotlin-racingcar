package study.step3.race.mock

import study.step3.race.reader.InputReader

class MockInputReader(
    private val inputs: List<String>,
) : InputReader {

    private var index = 0

    override fun raedLine(): String? = if (index < inputs.size) inputs[index++] else null
}
