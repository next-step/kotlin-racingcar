package carracing

import carracing.util.CarRacingManagerForTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class CarRacingViewTest : StringSpec({

    "viewResult 는 자동차 경주 디스플레이하기 위한 데이터를 넘겨준다" {
        // given
        val carDistances = listOf(1, 3, 4)
        val carListManager = CarListManager(carDistances.map { distance -> Car(distance) })
        val randomNumberCarRacingManager = CarRacingManagerForTest(carListManager)
        val carRacingView = CarRacingView("-", "\n")
        val monitoringValue = """--
----
-----"""

        // whenÎ
        val viewResult = carRacingView.getViewString(randomNumberCarRacingManager)

        // then
        viewResult shouldBe monitoringValue
    }

    "경주에 참가한 자동차가 없는 경우 빈 문자열이 나온다" {
        // given
        val carRacingManager = CarRacingManagerForTest(CarListManager())
        val carRacingView = CarRacingView("-", "\n")
        val monitoringValue = ""

        // whenÎ
        val viewResult = carRacingView.getViewString(carRacingManager)

        // then
        viewResult shouldBe monitoringValue
        viewResult.length shouldBe 0
    }
})
