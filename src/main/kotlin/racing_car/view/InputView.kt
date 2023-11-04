package racing_car.view

import racing_car.domain.Car

object InputView {

    fun inputCars(): List<Car> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

        val carNames = readlnOrNull()
            ?.split(",")
            ?.map(String::trim)

        requireNotNull(carNames) { "경주할 자동차 이름이 잘못 입력되었습니다." }

        return carNames.map { Car(name = it) }
    }

    fun inputRacingRound(): Int {
        println("시도할 횟수는 몇 회인가요?")

        val racingRound = readlnOrNull()?.toIntOrNull()
        require(racingRound != null && racingRound > 0) { "시도할 횟수는 자연수값입니다." }

        return racingRound
    }
}
