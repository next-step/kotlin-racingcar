package racingcar.domain.game

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.booleans.shouldBeTrue
import racingcar.domain.car.Car
import racingcar.domain.car.CarName
import racingcar.domain.rule.RandomMoveRule
import racingcar.domain.rule.RandomNumberGeneratorInBound

class CarMoverTest : ExpectSpec({
    expect("이동 규칙에 따라 차를 움직인다") {
        forAll(
            row(true),
            row(false),
        ) { shouldMove ->
            val cars = listOf(Car(0, CarName("name1"), 0), Car(1, CarName("name2"), 0))
            val randomNumber = if (shouldMove) 4 else 0
            val moveRule = RandomMoveRule(RandomNumberGeneratorInBound(randomNumber..randomNumber))
            val round = CarMover(moveRule)

            round.move(cars)

            val expectPosition = if (shouldMove) 1 else 0
            cars.all { it.position == expectPosition }.shouldBeTrue()
        }
    }
})
