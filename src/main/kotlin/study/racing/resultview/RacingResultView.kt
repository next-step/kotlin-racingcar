package study.racing.resultview

import study.racing.car.Car
import study.racing.renderer.Renderer

class RacingResultView(
    private val character: String,
    private val renderer: Renderer,
) : ResultView {
    override fun printMessage() {
        renderer.render("실행 결과")
    }

    override fun printRoundResult(cars: List<Car>) {
        cars.forEach {
            renderer.render(format(it))
        }
        renderer.render("")
    }

    override fun printWinners(cars: List<Car>) {
        renderer.render(cars.joinToString(",") { it.name }.plus(" 가 최종 우승했습니다."))
    }

    private fun format(car: Car): String {
        return "${car.name}: ${characterized(car.totalMoved)}"
    }

    private fun characterized(times: Int) = character.repeat(times)
}
