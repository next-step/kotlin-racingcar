package week1.racingcar

class Car(
    val name: String,
) {
    var mileage = 0
        private set

    fun go() {
        mileage++
    }
}