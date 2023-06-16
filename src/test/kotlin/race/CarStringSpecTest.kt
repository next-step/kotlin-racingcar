package race

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import race.model.Car

class CarStringSpecTest : StringSpec({
    "자동차는 이름과 위치를 가진다" {
        listOf(
            "홍길동" to 1,
            "제이슨" to 10
        ).forAll {
            val name = it.first
            val position = it.second
            val actual = Car(_name = name, _position = position)
            actual.name shouldBe name
            actual.position shouldBe position
        }
    }
})
