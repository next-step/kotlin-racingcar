package racingcar.ui

object InputView {
    var carNumber: Int = 0
        private set
    var tryNumber: Int = 0
        private set

    fun input() {
        println(MessageCode.CarNumberQuestion.message)
        carNumber = requireNotNull(readLine()?.toInt())

        println(MessageCode.TryNumberQuestion.message)
        tryNumber = requireNotNull(readLine()?.toInt())
    }
}
