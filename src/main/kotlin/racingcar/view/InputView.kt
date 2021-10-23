package racingcar.view

object InputView {
    fun getReadLine(message: String): Int {
        println(message)
        return readLine()!!.toInt()
    }
}
