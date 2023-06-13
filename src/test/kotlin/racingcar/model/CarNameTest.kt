package racingcar.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

@DisplayName("자동차 이름")
class CarNameTest : StringSpec({

    "문자열로 생성" {
        listOf("1", "pobi", "crong")
            .forAll {
                shouldNotThrowAny { CarName(it) }
            }
    }

    "이름이 5자를 초과하면 예외 발생" {
        listOf("123456", "pobipobi")
            .forAll {
                shouldThrowExactly<IllegalArgumentException> { CarName(it) }
            }
    }
})

val SAMPLE_NAME: CarName = CarName("any")
