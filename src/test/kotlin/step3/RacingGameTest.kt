package step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe

class RacingGameTest : FunSpec({
    context("입력한 숫자 만큼 자동차가 생성된다") {
        forAll(
            row(3, 5),
            row(10, 10),
            row(8, 2),
        ) { cars, times ->
            val racing = RacingGame(List(cars) { Car() }, times)
            racing.play()
            racing.records.size shouldBe cars
        }
    }

    context("게임 결과는 입력한 숫자보다 많을 수 없다") {
        forAll(
            row(3, 5),
            row(10, 10),
            row(8, 2),
        ) { cars, times ->
            val racing = RacingGame(List(cars) { Car() }, times)
            racing.play()
            racing.records.map { it.value.size shouldBeLessThanOrEqual times }
        }
    }

    context("4보다 큰거나 같은경우 자동차는 전진한다") {
        forAll(
            row(4),
            row(11),
            row(20),
        ) { move ->
            val car = Car()
            car.moveOrStop(move) shouldBe "-"
        }
    }

    context("4보다 작은경우 자동차는 전진한다") {
        forAll(
            row(0),
            row(2),
            row(3),
        ) { move ->
            val car = Car()
            car.moveOrStop(move) shouldBe ""
        }
    }
})
