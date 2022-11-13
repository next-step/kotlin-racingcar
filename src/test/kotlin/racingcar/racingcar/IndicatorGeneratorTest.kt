package racingcar.racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

internal class IndicatorGeneratorTest : StringSpec({

    val indicatorGenerator = IndicatorGenerator()

    "자동차 경주에 사용되는 랜덤 숫자 생성 테스트" {
        val result = indicatorGenerator.generate(3, 100)

        result.size shouldBe 100

        result.forEach { turnIndicator ->
            (0..2).forEach { carIndex ->
                turnIndicator.findByCarIndex(carIndex) shouldBeInRange 0..9
            }
        }
    }
})
