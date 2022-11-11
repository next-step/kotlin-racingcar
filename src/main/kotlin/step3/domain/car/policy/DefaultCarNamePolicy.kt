package step3.domain.car.policy

object DefaultCarNamePolicy : CarNamePolicy {
    const val MIN_LEHGTH_OF_CAR_NAME = 1
    const val MAX_LENGTH_OF_CAR_NAME = 5

    override fun isValidName(name: String): Boolean = name.length in (MIN_LEHGTH_OF_CAR_NAME..MAX_LENGTH_OF_CAR_NAME)
}
