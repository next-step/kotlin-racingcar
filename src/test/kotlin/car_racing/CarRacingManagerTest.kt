package car_racing

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarRacingManagerTest : StringSpec({
    "addCar 는 경기용 자동차를 추가한다" {
        // given
        val car = Car()
        val carRacingManagerForTest = CarRacingManagerForTest(listOf(car))

        // then
        carRacingManagerForTest.getCarSize() shouldBe 1
    }

    "validateCarsIndex 는 설정하는 자동차의 Index 번호를 검증한다" {
        // given
        val car = Car()
        val carRacingManagerForTest = CarRacingManagerForTest(listOf(car))
        val carIndex = -1

        // when
        val shouldThrowExactly = shouldThrowExactly<IllegalArgumentException> {
            carRacingManagerForTest.validateCarsIndex(carIndex)
        }

        // then
        shouldThrowExactly.message shouldBe "음수 값으로 시스템을 실행할수 없습니다"
    }

    "validateCarsIndex 는 cars 에 사이즈를 넘긴 값을 넣으면 에러가 발생한다" {
        // given
        val car = Car()
        val carRacingManagerForTest = CarRacingManagerForTest(listOf(car))
        val carIndex = 2

        // when
        val shouldThrowExactly = shouldThrowExactly<IllegalArgumentException> {
            carRacingManagerForTest.validateCarsIndex(carIndex)
        }

        // then
        shouldThrowExactly.message shouldBe "존재 하지 않은 번호 입니다"
    }
})

class CarRacingManagerForTest(carsList: List<Car>) : CarRacingManager(carsList) {

    override fun getMonitoringInformation(): String {
        return "test"
    }
}
