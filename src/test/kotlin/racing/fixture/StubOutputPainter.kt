package racing.fixture

import racing.port.OutputPainter

class StubOutputPainter : OutputPainter {

    lateinit var outputBuffer: String

    override fun draw(buffer: String) {
        outputBuffer = buffer
    }
}
