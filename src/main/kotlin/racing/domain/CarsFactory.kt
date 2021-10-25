package racing.domain

class CarsFactory(private val engine: Engine) {

    fun create(names: List<CarName>): Cars {
        val cars = names.map { Car(engine, it) }
        return Cars(cars)
    }
}
