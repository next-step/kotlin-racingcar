package study.racing.resultview

import study.racing.renderer.Renderer

class InputMirroringRenderer(private val mirror: MutableList<String>) : Renderer {
    override fun render(element: Any?) {
        mirror.add(element as String)
    }
}
