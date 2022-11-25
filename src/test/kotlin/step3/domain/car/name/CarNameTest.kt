package step3.domain.car.name

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.assertThrows
import step3.domain.car.RacingCar

class CarNameTest : FunSpec({
    context("5자리 이하의 이름의 경우, RacingCar 생성 성공") {
        withData(
            (1..CarName.MAX_CAR_NAME_LENGTH).map { CarNameDataSet.testData(it) }
        ) { validCarName ->
            RacingCar(validCarName) shouldNotBe null
        }
    }

    context("5자리 초과한 이름의 경우, RacingCar 생성 실패") {
        withData(
            (CarName.MAX_CAR_NAME_LENGTH + 1..100).map { CarNameDataSet.testData(it) }
        ) { invalidCarName ->
            assertThrows<IllegalArgumentException> { RacingCar(invalidCarName) }
        }
    }

    test("빈 문자열의 경우, RacingCar 생성 실패") {
        val emptyString = ""

        assertThrows<IllegalArgumentException> { RacingCar(emptyString) }
    }
})
