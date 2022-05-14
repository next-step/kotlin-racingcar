package step3

class RacingGame(private val inputCarCount: Int, private val inputMoveCount: Int) {

    fun racing() {
        val carList: List<Car> = List(inputCarCount) { i -> Car(i) }
        for (index in 0 until inputMoveCount) {
            for (car in carList) {
                car.move()
                printPosition(car.position)
            }
            println()
        }
    }

    fun printPosition(position: Int) {
        println("-".repeat(position))
    }
}

class Car(val id: Int) {
    var position: Int = 0

    fun move() {
        if ((0..9).random().takeIf { it >= 4 } != null) {
            position++
        }
    }
}
