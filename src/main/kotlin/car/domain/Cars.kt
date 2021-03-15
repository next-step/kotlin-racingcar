package car.domain

class Cars(val cars: List<MovableCar>) {

    private val _histories: MutableList<CarMoveHistoryCollection> = mutableListOf()
    val histories: List<CarMoveHistoryCollection>
        get() = _histories
    val winners: Winners
        get() = Winners(_histories.last())

    constructor(
        carNameCollection: CarNameCollection,
        energyProvider: EnergyProvider = RandomEnergyProvider()
    ) : this(carNameCollection.names.map { Car(it, energyProvider) })

    fun move(times: Int) {
        repeat(times) {
            moveAllCar()
        }
    }

    private fun moveAllCar() {
        cars.forEach {
            it.move()
        }
    }
}
