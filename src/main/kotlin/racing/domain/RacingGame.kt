package racing.domain

import racing.dto.CarDto

data class RacingGame(private val cars: List<Car>, private val movingRule: RacingMovingRule) {
    fun goRacing(): List<CarDto> {
        var carDtos: MutableList<CarDto> = mutableListOf()
        repeat(movingRule.movingCount) {
            for (car in cars) {
                car.forward(movingRule)
                carDtos.add(CarDto(car.name.name, car.route))
            }
        }
        return carDtos
    }
}
