package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange

class OilStationTest : FunSpec({
    test("오일(연료) 를 랜덤하게 구하는 테스트") {
        (0..99).forEach { _ ->
            // when
            val oil = OilStation.generateOilRandomly()
            // then
            oil.amount shouldBeInRange (0..9)
        }
    }
})
