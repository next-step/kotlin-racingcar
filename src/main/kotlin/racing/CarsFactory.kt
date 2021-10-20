package racing

object CarsFactory {

    private val engine = RandomEngine

    fun create(names: List<CarName>): Cars {
        val cars = names.map { Car(engine) }
        return Cars(cars)
    }
}
