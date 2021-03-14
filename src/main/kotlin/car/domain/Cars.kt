package car.domain

class Cars(private val cars: List<Car>, private val energyProvider: EnergyProvider = RandomEnergyProvider()) {

    private val _histories: MutableList<CarMoveHistoryCollection> = mutableListOf()
    val histories: List<CarMoveHistoryCollection>
        get() = _histories
    val winners: Winners
        get() = Winners(_histories.last())

    constructor(
        carNameCollection: CarNameCollection,
        energyProvider: EnergyProvider = RandomEnergyProvider()
    ) : this(carNameCollection.names.map { Car(it) }, energyProvider)

    fun move(times: Int) {
        repeat(times) {
            moveAllCar()
        }
    }

    private fun moveAllCar() {
        val histories: List<CarMoveHistory> = cars.map {
            it.move(energyProvider.getEnergy())

            CarMoveHistory(it.name, it.currentPosition)
        }

        _histories.add(CarMoveHistoryCollection(histories))
    }
}
