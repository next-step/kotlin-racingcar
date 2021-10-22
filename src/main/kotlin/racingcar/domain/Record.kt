package racingcar.domain

@JvmInline
value class Record private constructor(val score: String) {

    constructor(car: RacingCar) : this("${car.name.value} : ${RACING_CAR_EMOJI.repeat(car.position.value)}")

    companion object {
        private const val RACING_CAR_EMOJI = "🚘"
    }
}
