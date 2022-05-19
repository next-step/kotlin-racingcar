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
            val racing = RacingGame()
            racing.play(cars, times)
            racing.carList.size shouldBe cars
        }
    }

    context("게임 결과는 입력한 숫자보다 많을 수 없다") {
        forAll(
            row(3, 5),
            row(10, 10),
            row(8, 2),
        ) { cars, times ->
            val racing = RacingGame()
            racing.play(cars, times)
            racing.carList.size shouldBe cars
            racing.records.map { it.value.size shouldBeLessThanOrEqual times }
        }
    }
})
