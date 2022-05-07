package gameobj

import port.OutputPainter

class StandardOutputPainter : OutputPainter {

    override fun draw(buffer: String) {
        println(buffer)
    }
}
