package racingCar.domain

private const val THRESHOLD = 4
class Car {
    var position: Int = 0
        private set

    fun move(value: Int) {
        if(value >= THRESHOLD){
            position ++
        }
    }
}
