package racingcar.domain.game

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.booleans.shouldBeTrue
import racingcar.domain.car.Car
import racingcar.domain.car.CarName
import racingcar.domain.rule.AlwaysMoveRule
import racingcar.domain.rule.AlwaysStopRule

class CarMoverTest : ExpectSpec({
    expect("이동 규칙에 따라 차를 움직인다") {
        forAll(
            row(AlwaysMoveRule(1)),
            row(AlwaysStopRule()),
        ) { moveRule ->
            val cars = listOf(Car(CarName("name1"), 0), Car(CarName("name2"), 0))
            val round = CarMover(moveRule)

            round.move(cars)

            val expectPosition = moveRule.determineMoveDistance()
            cars.all { it.position == expectPosition }.shouldBeTrue()
        }
    }
})
