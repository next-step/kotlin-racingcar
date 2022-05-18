package racing.utils

import racing.controller.dto.CarView
import racing.controller.dto.ResultView

class ScreenView {
    companion object {
        fun view(resultView: ResultView) {
            resultView.roundResultViews.forEach {
                println(String.format("round: %d", it.round))
                showDistance(it.carViews)
                println("========")
            }

            println("우승자: " + resultView.winners)
        }

        private fun showDistance(carViews: List<CarView>) {
            carViews.forEach { carView ->
                print(carView.name + ":")
                repeat(carView.position) {
                    print("-")
                }
                println()
            }
        }
    }
}
