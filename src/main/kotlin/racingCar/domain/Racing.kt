package racingCar.domain

import racingCar.dto.ResultDto
import java.util.stream.IntStream

class Racing {

    fun play(carNumber :Int , tryNumber: Int) : ResultDto {
        val cars = Cars(carNumber , RandomStrategy());
        IntStream.range(0,tryNumber)
            .forEach { cars.moveByStrategy() }
        return ResultDto(cars)
    }
}
