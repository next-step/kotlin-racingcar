package racingcar.domain

enum class AwardsStrategy(
    val awards: (RacingGame) -> List<Car>
) {

    FIND_WINNERS( { cars ->
        require(cars.value.isNotEmpty())

        cars.value.groupBy { car ->
            car.position.value
        }.maxByOrNull { carsEntry ->
            carsEntry.value.maxOf { car ->
                car.position.value
            }
        }?.value!!
    })

}