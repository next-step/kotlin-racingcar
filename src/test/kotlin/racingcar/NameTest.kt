package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import racingcar.domain.Name

class NameTest : BehaviorSpec({

    val name = "yuuuzzzin"
    Given("5자를 초과하는 이름이") {
        When("전달되면") {
            Then("IllegalArgumentException 예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    Name.of(name)
                }
            }
        }
    }
})
