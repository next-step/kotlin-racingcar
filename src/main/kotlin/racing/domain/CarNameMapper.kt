package racing.domain

object CarNameMapper {
    fun map(carNames: List<String>): List<Car> {
        return carNames.map { Car(it.trim()) }
    }
}
