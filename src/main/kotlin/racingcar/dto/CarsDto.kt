package racingcar.dto

import racingcar.domain.Car

@JvmInline
value class CarsDto(val cars: List<Car>)
