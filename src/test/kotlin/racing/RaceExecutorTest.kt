package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class RaceExecutorTest : BehaviorSpec({
    given("입력받은 자동차 대수만큼 자동차 생성") {
        val carList = RaceExecutor.prepareCar(3)
        carList.size shouldBe 3
    }

    given("각 자동차는 랜덤값에 따라서 전진") {
        `when`("랜덤값이 4이상이면 자동차가 전진") {
            val carList = RaceExecutor.prepareCar(3)

            RaceExecutor.raceCarRandomly(carList, 5) { 5 }
            carList[1].position shouldBe "-----"
        }

        `when`("랜덤값이 4미만이면 자동차는 멈춤") {
            val carList = RaceExecutor.prepareCar(3)

            RaceExecutor.raceCarRandomly(carList, 5) { 1 }
            carList[1].position shouldBe ""
        }
    }
})
