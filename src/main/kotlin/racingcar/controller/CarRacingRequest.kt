package racingcar.controller

import racingcar.domain.car.CarName

class CarRacingRequest(
    val roundCount: Int,
    carNames: List<String>,
) {
    val carNames: List<CarName> = carNames.map { CarName(it) }

    init {
        require(carNames.isNotEmpty()) { "자동차 이름은 한 개 이상이어야 합니다" }
        require(roundCount > 0) { "시도 횟수는 0보다 커야 합니다" }
    }
}
