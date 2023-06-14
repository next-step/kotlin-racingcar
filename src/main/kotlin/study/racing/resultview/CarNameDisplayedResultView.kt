package study.racing.resultview

import study.racing.car.Car
import study.racing.renderer.Renderer

class CarNameDisplayedResultView(
    private val character: String,
    private val renderer: Renderer
) : ResultView {
    override fun printResult(cars: List<Car>) {
        cars.forEach {
            renderer.render(format(it))
        }
        renderer.render("")
    }

    private fun format(car: Car): String {
        return "${car.name}: ${characterized(car.totalMoved)}"
    }

    private fun characterized(times: Int) = character.repeat(times)
}
