package carRace

sealed interface CarsProvider {

    fun provide(carMovingStrategy: CarMovingStrategy): List<Car>

    class Manual(private val carNames: List<String>) : CarsProvider {
        override fun provide(carMovingStrategy: CarMovingStrategy): List<Car> =
            carNames.map { Car(it, 0, carMovingStrategy) }
    }

    object UserInput : CarsProvider {
        override fun provide(carMovingStrategy: CarMovingStrategy): List<Car> {
            val carNames = println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).").run {
                readln()
                    .trim()
                    .split(",")
                    .map { it.trim() }
            }
            return carNames.map { Car(it, 0, carMovingStrategy) }
        }
    }
}
