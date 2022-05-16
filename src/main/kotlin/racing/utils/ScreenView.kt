package racing.utils

import racing.controller.dto.RoundResultView

class ScreenView {
    companion object {
        fun view(resultViews: List<RoundResultView>) {
            resultViews.forEach {
                println(String.format("round: %d", it.round))
                showDistance(it.positions)
                println("========")
            }
        }

        private fun showDistance(positions: List<Int>) {
            positions.forEach {
                repeat(it) {
                    print("-")
                }
                println()
            }
        }
    }
}
