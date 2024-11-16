package racingcar.domain.vo

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.assertThrows

class CarNameTest : StringSpec({
    "이름 (CarName)은 5자를 초과할 수 없고 공백이 될 수 없다." {
        forAll(
            row(""),
            row("dinosaur"),
            row("GoodDinoBadDino"),
            row(" Dino "),
            row("한글여섯글자"),
        ) { name ->
            val exception =
                assertThrows(IllegalArgumentException::class.java) {
                    CarName(name)
                }
            exception.message shouldBe "자동차 이름은 1자 이상, 5자 이하만 가능합니다."
        }
    }
})
