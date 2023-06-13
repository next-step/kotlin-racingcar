package step3

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll
import io.kotest.property.exhaustive.exhaustive

class RacingCarTest : StringSpec({
    val racingCar = RacingCar()

    "움직이기 성공했을때의 차의 위치값 테스트" {
        val successValues = listOf(0, 1, 2, 3, 4).exhaustive()
        var checkValue = 0
        checkAll(successValues) { a ->
            racingCar.tryMove(value = a) shouldBe checkValue++
        }
    }
})
