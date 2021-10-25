package racingcar.view

object InputView {
    fun getSystemInputByQuestion(message: String): Int {
        println(message)
        return readLine()!!.toInt()
    }
}
