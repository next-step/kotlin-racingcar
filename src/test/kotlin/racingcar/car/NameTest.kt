package racingcar.car

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.inspectors.forAll

class NameTest : ShouldSpec({
    context("Create") {
        should("create a name") {
            listOf("a", "12", "123", "1234", "12345", "sunny").forAll {
                shouldNotThrowAny {
                    Name("sun")
                }
            }
        }

        should("throw error if name is blank") {
            listOf("", " ").forAll {
                shouldThrow<IllegalArgumentException> {
                    Name(it)
                }
            }
        }

        should("throw error if name length is below 1 or greater than 5") {
            listOf("", "sunny1").forAll {
                shouldThrow<IllegalArgumentException> {
                    Name(it)
                }
            }
        }
    }
})
