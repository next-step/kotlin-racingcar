package next.step.racing.domain.car

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarNamesTest : StringSpec({

    "comma로 구분하여 차이름 리스트 생성" {
        CarNames.from("gv1,gv2") shouldBe CarNames(listOf(CarName("gv1"), CarName("gv2")))
    }
})
