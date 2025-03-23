package racingcar.car

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll

class NameTest : FunSpec({
    context("create") {
        test("create name does not throw exception") {
            listOf("a", "12", "123", "1234", "12345", "sunny").forAll {
                shouldNotThrowAny {
                    Name("sun")
                }
            }
        }

        test("create throws exception if name is blank") {
            listOf("", " ").forAll {
                shouldThrow<IllegalArgumentException> {
                    Name(it)
                }
            }
        }

        test("create throws exception if name length is below 1 or greater than 5") {
            listOf("", "sunny1").forAll {
                shouldThrow<IllegalArgumentException> {
                    Name(it)
                }
            }
        }
    }
})
