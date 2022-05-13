package racingcar.view.input

open class Input {

    open fun readCar(): Int {
        return readLine()!!.toInt()
    }

    open fun readTry(): Int {
        return readLine()!!.toInt()
    }
}