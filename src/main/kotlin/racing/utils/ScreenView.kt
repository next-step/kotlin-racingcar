package racing.utils

import racing.controller.dto.RoundResultView

class ScreenView {
    companion object {
        private val view: MutableMap<Int, String> = mutableMapOf()

        fun view(resultViews: List<RoundResultView>) {
            resultViews.forEach {
                println(String.format("round: %d", it.round))
                showDistance(it.positions)
                println("========")
            }
        }

        private fun showDistance(positions: List<Int>) {
            for (i in positions.indices) {
                if (!view.containsKey(i)) {
                    view[i] = ""
                }

                if (positions[i] == 1) {
                    view[i] = view[i] + "-"
                }
            }
            view.forEach {
                println(it.value)
            }
        }
    }
}
