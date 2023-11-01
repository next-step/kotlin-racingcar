package racing.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class CarNameTest : StringSpec({
    "자동차 이름은 5자를 초과할 수 없다" {
        val error = assertThrows<IllegalArgumentException> {
            CarName("abcdef")
        }
        error.message shouldBe "자동차의 이름은 5자를 초과할 수 없습니다."
    }
})
