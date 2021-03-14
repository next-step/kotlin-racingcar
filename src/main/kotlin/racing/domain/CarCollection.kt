package racing.domain

data class CarCollection(val cars: List<Car>) {
    fun getNames(): List<String> {
        return cars.map { it.name }
    }
}
