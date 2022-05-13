package racing.utils

import racing.port.OutputPainter

class StandardOutputPainter : OutputPainter {

    override fun draw(buffer: String) {
        print(buffer)
    }
}
