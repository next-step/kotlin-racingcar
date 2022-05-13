package fixture

import port.OutputPainter

class StubOutputPainter : OutputPainter {

    val outputBuffer = mutableListOf<String>()

    override fun draw(buffer: String) {
        outputBuffer += buffer
    }
}
