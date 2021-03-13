package car.business

class Cars(private val cars: List<Car>, private val energyProvider: EnergyProvider = RandomEnergyProvider()) {

    constructor(
        carNameCollection: CarNameCollection,
        energyProvider: EnergyProvider = RandomEnergyProvider()
    ) : this(carNameCollection.names.map { Car(it) }, energyProvider)

    private val _histories: MutableList<CarMoveHistoryCollection> = ArrayList()
    val histories: List<CarMoveHistoryCollection>
        get() = _histories

    fun move(times: Int) {
        repeat(times) {
            moveAllCar()
        }
    }

    private fun moveAllCar() {
        val histories: List<CarMoveHistory> = cars.map {
            it.move(energyProvider.getEnergy())

            CarMoveHistory(it.name, it.currentPosition)
        }.toList()

        _histories.add(CarMoveHistoryCollection(histories))
    }
}
