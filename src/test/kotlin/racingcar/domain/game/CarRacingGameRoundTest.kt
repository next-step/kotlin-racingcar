package racingcar.domain.game

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.booleans.shouldBeTrue
import racingcar.domain.rule.RandomNumberGeneratorMock
import racingcar.domain.car.Car
import racingcar.domain.rule.RandomMoveRule

class CarRacingGameRoundTest : ExpectSpec({
    expect("라운드 생성시 전달된 자동차와 이동 규칙으로 라운드가 진행된다") {
        forAll(
            row(true),
            row(false),
        ) { shouldMove ->
            val cars = listOf(Car(0, 0), Car(1, 0))
            val randomNumber = if (shouldMove) 4 else 0
            val moveRule = RandomMoveRule(RandomNumberGeneratorMock(randomNumber))
            val round = CarRacingGameRound(cars, moveRule)

            round.run()

            val expectPosition = if (shouldMove) 1 else 0
            cars.all { it.position == expectPosition }.shouldBeTrue()
        }
    }
})
