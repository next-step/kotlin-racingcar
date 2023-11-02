package study.racingcar.application

import study.racingcar.domain.RacingCar
import study.racingcar.domain.RacingCars

/**
 * CarName 을 Wrapping 하는 일급 컬렉션
 * */
data class CarNames(private val carNames: List<CarName>) {

    /**
     * 자동차 이름으로 된 배열을 받아서 RacingCars 객체를 반환한다.
     * */
    fun prepareForRace(): RacingCars {
        return carNames
            .map { carName -> RacingCar(carName) }
            .let { RacingCars(it) }
    }
}
