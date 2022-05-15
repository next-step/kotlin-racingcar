package carracing

import carracing.util.CarRacingManagerForTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarRacingManagerTest : StringSpec({
    "getCarList 는 CarList 데이터 가져온다" {
        // given
        val distance = 3
        val carListManager = CarListManager(listOf(Car(distance)))
        val carRacingManagerForTest = CarRacingManagerForTest(carListManager)

        // when
        val carList = carRacingManagerForTest.getCarList()

        // then
        carList.size shouldBe 1
        carList[0].distance shouldBe distance
    }
})
