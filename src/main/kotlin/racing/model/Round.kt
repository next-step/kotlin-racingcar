package racing.model

data class Round(val cars: List<Car>) {

    fun next(randomNumbers: List<Int>): Round {
        return Round(
            cars.mapIndexed { idx, car ->
                car.goOrNot(randomNumbers[idx])
            }
        )
    }
}