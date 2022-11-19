package racingcar

object CarStore : Store<Car> {
    private var cars = listOf<Car>()

    override fun findAll(): List<Car> {
        return this.cars
    }

    override fun saveAll(list: List<Car>): List<Car> {
        this.cars = list
        return this.cars
    }
}
