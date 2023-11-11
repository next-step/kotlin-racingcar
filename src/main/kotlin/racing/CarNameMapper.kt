package racing

object CarNameMapper {
    fun map(carNames: List<String>): List<Car> {
        return carNames.map { Car(it.trim()) }
    }
}
