package racingCar.domain

@JvmInline
value class CarPosition(
    val value: Int
) {

    fun add(): CarPosition {
        return CarPosition(value + 1)
    }
}
