package racingcar.view

class InputView {

    fun readInt(description: String): Int {
        println(description)
        return readLine()!!.toInt()
    }
}
