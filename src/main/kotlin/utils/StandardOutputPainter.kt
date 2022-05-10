package utils

import port.OutputPainter

class StandardOutputPainter : OutputPainter {

    override fun draw(buffer: String) {
        print(buffer)
    }
}
