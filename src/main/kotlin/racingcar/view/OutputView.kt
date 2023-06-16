package racingcar.view

class OutputView : OutputViewProtocol {

    override fun printValue(value: Int) {
        for (i in 0 until value) {
            print("-")
        }
        println()
    }
}
