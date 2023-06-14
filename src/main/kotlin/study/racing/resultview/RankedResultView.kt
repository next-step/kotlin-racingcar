package study.racing.resultview

import study.racing.car.Car
import study.racing.renderer.Renderer

class RankedResultView(
    private val renderer: Renderer
) : ResultView {
    override fun printResult(cars: List<Car>) {
        renderer.render(makeMessage(cars))
    }

    private fun makeMessage(winners: List<Car>) =
        winners.joinToString(",") { it.name }.plus(" 가 최종 우승했습니다.")
}
