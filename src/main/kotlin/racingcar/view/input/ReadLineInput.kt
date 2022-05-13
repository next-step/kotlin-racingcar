package racingcar.view.input

class ReadLineInput : Input {

    override fun readCar(): Int {
        return readLine()!!.toInt()
    }

    override fun readTry(): Int {
        return readLine()!!.toInt()
    }
}
