package racingcar.model

interface Cars {
    val value: List<Car>
    fun move(random: () -> MoveFactor)
    fun carsInLead(): Cars
}
