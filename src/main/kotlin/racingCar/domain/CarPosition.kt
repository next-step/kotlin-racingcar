package racingCar.domain

@JvmInline
value class CarPosition(
    val position: Int
) {

    fun add(): CarPosition {
        return CarPosition(position + 1)
    }
}
