package racingcar.view

class OutputView {
    private var isTitle = true

    fun showRaceState(position: String, isLastCarCycle: Boolean) {
        addTitle()
        println(position)
        addLineForLastCar(isLastCarCycle)
    }

    private fun addTitle() {
        if (isTitle) {
            println("실행 결과")
        }

        isTitle = false
    }

    private fun addLineForLastCar(isLastCarCycle: Boolean) {
        if (isLastCarCycle) {
            println()
        }
    }
}
