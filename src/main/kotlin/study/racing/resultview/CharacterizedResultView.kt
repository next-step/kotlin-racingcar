package study.racing.resultview

import study.racing.car.Car
import study.racing.renderer.Renderer

class CharacterizedResultView(
    private val character: String,
    private val renderer: Renderer
) : ResultView {

    override fun printResult(cars: List<Car>) {
        cars.forEach {
            renderer.render(characterized(it.totalMoved))
        }
        renderer.render("")
    }

    private fun characterized(times: Int) = character.repeat(times)
}
