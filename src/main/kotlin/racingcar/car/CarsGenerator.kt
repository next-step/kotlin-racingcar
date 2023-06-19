package racingcar.car

class CarsGenerator(private val carNames: CarNames, private val moveStrategy: MoveStrategy) {

    fun generate(): Cars {
        val cars = mutableListOf<Car>()
        carNames.names.forEach { name ->
            cars.add(Car(name, moveStrategy))
        }
        return Cars(cars)
    }
}
