package racingcar.view

class OutputView {
    private var isTitle = true

    fun showRaceState(name: String, position: String, isLastCarCycle: Boolean) {
        addTitle()
        println("$name : $position")
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
