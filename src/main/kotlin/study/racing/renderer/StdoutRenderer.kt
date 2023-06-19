package study.racing.renderer

class StdoutRenderer : Renderer {
    override fun render(element: Any?) {
        println(element)
    }
}
