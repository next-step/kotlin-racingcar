package racingcar.view

class OutputView {
    var isTitle = true
    fun showResult(position: String, isLastCarCycle: Boolean) {
        if (isTitle) {
            println("실행 결과")
        }
        isTitle = false
        println(position)
        if (isLastCarCycle) {
            println()
        }
    }
}
