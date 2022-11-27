package racingcar.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarNameParseServiceTest : FunSpec({
    test("parse 함수는 자동차 이름 input 값을 ,를 이용해 파싱할 수 있다.") {
        val carNames = "pobi,crong,honux"

        CarNameParseService.parse(carNames) shouldBe listOf("pobi", "crong", "honux")
    }
})
