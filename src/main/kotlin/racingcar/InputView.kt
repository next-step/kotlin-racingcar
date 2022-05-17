package racingcar

class InputView(viewText: String) {
    init {
        println(viewText)
    }

    val value: Int
        get() = readLine()!!.toInt()
}
