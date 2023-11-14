package racingcar.domain

object WinnerCar {
    fun from(racingCars: Cars): List<Car> {
        return racingCars.cars
            .filter { it.position == racingCars.maxOfPositions() }
    }
}
