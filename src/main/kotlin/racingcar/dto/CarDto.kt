package racingcar.dto

import racingcar.domain.Car

data class CarDto(val name: String, val position: Int) {
    companion object {
        fun from(car: Car): CarDto {
            return CarDto(
                name = car.name,
                position = car.position
            )
        }
    }
}

data class CarsDto(val carsDto: List<CarDto>) {
    fun racingTrace() = buildString {
        carsDto.forEach {
            appendLine("${it.name} : ${RACING_COURSE.repeat(maxOf(0, it.position))}")
        }
    }

    fun contentsFilter(predicate: (CarDto) -> Boolean): List<CarDto> {
        return carsDto.filter(predicate)
    }

    fun maxOfPositions(): Int {
        return carsDto.maxOf { car -> car.position }
    }

    companion object {
        private const val RACING_COURSE = "-"
    }
}
