package racingcar.view.input

class ReadInInput : Input {

    override fun readCar(): Int {
        return readln().toInt()
    }

    override fun readTry(): Int {
        return readln().toInt()
    }
}
