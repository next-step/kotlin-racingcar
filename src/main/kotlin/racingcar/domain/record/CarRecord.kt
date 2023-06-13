package racingcar.domain.record

import racingcar.domain.car.Car

data class CarRecord(
    val car: Car,
    val records: List<Int> // Car의 바퀴마다 position을 저장
)
