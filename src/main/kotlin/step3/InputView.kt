package step3

object InputView {

    fun readInputForNumbersOfCars(): Int {
        ResultView.printAskHowManyCars()
        val numberOfCarInput = readLine()
        return numberOfCarInput!!.toInt()
    }

    fun readInputForNumberOfTry(): Int {
        ResultView.printAskHowManyTry()
        val tryInput = readLine()
        return tryInput!!.toInt()
    }
}
