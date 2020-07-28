package racingCar

class Car {
    var distance: Int = 0
    private val standardValueToMove = 4

    fun changeStateRacingCar(inputRandomNum: Int) {

        if (inputRandomNum >= standardValueToMove) {
            runningRacingCar()
        } else {
            stoppedRacingCar()
        }
        printDistanceResult(this)
    }

    fun runningRacingCar(): Int = distance + 1
    fun stoppedRacingCar(): Int = this.run { distance + 0 } // distance + 0

    fun printDistanceResult(car: Car) = OutputView.getCarRacingResult(this)
}
