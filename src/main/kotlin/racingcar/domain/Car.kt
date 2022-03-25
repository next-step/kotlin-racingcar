package racingcar.domain

data class Car(
    val name: String,
    val accelerator: CarAccelerator = RacingCarAccelerator()
) {

    fun drive() {

    }

    fun movedDistance(): Int {
        return 0
    }
}
