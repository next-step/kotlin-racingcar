package racingCar

class Car {

    var distance: Int = 0
    private val standardValueToMove = 4

    fun changeStateRacingCar(inputRandomNum: Int) {
        println("randomNumber $inputRandomNum")
        if (inputRandomNum >= standardValueToMove) {
            distance += 1
        }
    }
}
