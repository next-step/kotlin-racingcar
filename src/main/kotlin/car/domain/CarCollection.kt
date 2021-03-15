package car.domain

class CarCollection(val cars: List<MovableCar>) {
    val maxPosition: Int
        get() = cars.map { it.currentPosition }.max() ?: 0

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
