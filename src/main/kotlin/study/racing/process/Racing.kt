package study.racing.process

import study.racing.domain.CarName
import study.racing.domain.Cars
import study.racing.domain.Round
import study.racing.strategy.MoveStrategy
import study.racing.strategy.RandomMoveStrategy

class Racing {

    fun playRacing(
        carNamesString: String,
        roundCount: Int,
        strategy: MoveStrategy = RandomMoveStrategy(),
    ): List<Cars> {
        val round = Round(roundCount)
        val carNames = splitForMakeCarNames(carNamesString)

        val racingCars = Cars.of(
            carNames,
            strategy
        )

        val copyCars = mutableListOf<Cars>()
        repeat(round.roundCount) {
            racingCars.moveTheCars()
            copyCars.add(racingCars.copy())
        }

        return copyCars
    }

    private fun splitForMakeCarNames(carNames: String): List<CarName> {

        require(carNames.isNotEmpty()) {
            "차량 이름을 정상적으로 등록해 주세요. 여러대 등록시 ',' 로 구분해서 작성해 주세요."
        }

        return carNames.trim()
            .split(",")
            .map {
                CarName(it)
            }
    }
}
