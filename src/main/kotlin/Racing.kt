import javax.swing.text.Position

class InputView {
    fun inputcarnumber(): Int {
        print("Please Enter cars number :")
        return readLine()!!.toInt()
    }

    fun inputcircuitnumber(): Int {
        print("Please Enter circuit number :")
        return readLine()!!.toInt()
    }
}

class OutputView() {
    fun printcircuit(number: Int) {
        println(result.repeat(number))
    }

    companion object {
        private val result = "_"
    }
}

class Cars(position: Int = DEFAULT_POSITION) {

    var position: Int = position
        private set

    fun move() {
        if ((0..9).random() >= FORWARD_Number) position++
    }

    companion object {
        private const val DEFAULT_POSITION = 0
        private const val FORWARD_Number = 4
    }
}

fun main() {
    val cars = InputView().inputcarnumber()
    val circuits = InputView().inputcircuitnumber()
    val carlist = MutableList(cars) { index -> Cars() }
    for (i in 0..circuits - 1) {
        for (car in carlist) {
            car.move()
            OutputView().printcircuit(car.position)
        }
        println(" ")
    }
}

