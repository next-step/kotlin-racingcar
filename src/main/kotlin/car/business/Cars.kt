package car.business

class Cars(names: List<String>, energyProvider: EnergyProvider = RandomEnergyProvider()) {

    private val cars: List<Car> = names.map { Car(it) }
    private val energyProvider: EnergyProvider = energyProvider

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
