package racingCar.domain

import racingCar.dto.ResultDto

class Racing {

    fun play(carNumber :Int , tryNumber: Int) : ResultDto {
        val cars = Cars(carNumber , RandomStrategy());
        return ResultDto()
    }
}
