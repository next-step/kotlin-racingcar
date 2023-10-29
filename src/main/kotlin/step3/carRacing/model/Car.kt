package step3.carRacing.model


class CarGenerator {
    companion object {
        fun generate(size: Int) = List<Car>(size) { Car() }
    }
}

class Car(var curPosition: Int = 0) {
    fun tryRace(randomNumber: Number) {
        if (randomNumber in 4 until 10) { // NOTE: 4 이상 일 경우 이동
            curPosition++
        }
    }
}
