package racingcar.util

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.const.CarException

internal class ValidatorTest : BehaviorSpec({
    Given("차의 이름을 받는 입력에 대해, ") {
        When("null 값이 들어오면, ") {
            then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Validator.validateCarNameStr(null)
                }
                exception.message shouldBe CarException.NULL_INPUT_ERROR
            }
        }

        When("빈 값이 들어오면, ") {
            then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Validator.validateCarNameStr("")
                }
                exception.message shouldBe CarException.NULL_INPUT_ERROR
            }
        }

        When("5자리를 초과한다면, ") {
            Then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Validator.validateCarNameStr("SangHyun")
                }
                exception.message shouldBe CarException.MORE_THAN_FIVE_WORD_ERROR
            }
        }

        When("정상적이라면, ") {
            Then("정상 수행된다.") {
                shouldNotThrowAny {
                    Validator.validateCarNameStr("SH")
                }
            }
        }
    }

    Given("시도 횟수를 받는 입력에 대해, ") {
        When("null 값이 들어오면, ") {
            Then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Validator.validateNumberOfTryStr(null)
                }
                exception.message shouldBe CarException.NULL_INPUT_ERROR
            }
        }

        When("빈 값이 들어오면, ") {
            then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Validator.validateNumberOfTryStr("")
                }
                exception.message shouldBe CarException.NULL_INPUT_ERROR
            }
        }

        When("숫자가 아니라면, ") {
            Then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Validator.validateNumberOfTryStr("SH")
                }
                exception.message shouldBe CarException.NOT_DIGIT_ERROR
            }
        }

        When("1 이상이 아니라면, ") {
            Then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Validator.validateNumberOfTryStr("0")
                }
                exception.message shouldBe CarException.MORE_THAN_ONE
            }
        }
        When("정상적이라면, ") {
            Then("정상 수행된다.") {
                shouldNotThrowAny {
                    Validator.validateNumberOfTryStr("3")
                }
            }
        }
    }

    Given("파싱 해야하는 입력에 대해, ") {
        When("null 값이 들어오면, ") {
            then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Validator.validateParserStr(null)
                }
                exception.message shouldBe CarException.NULL_INPUT_ERROR
            }
        }

        When("빈 값이 들어오면, ") {
            then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Validator.validateParserStr("")
                }
                exception.message shouldBe CarException.NULL_INPUT_ERROR
            }
        }

        When("정상적이라면, ") {
            Then("정상 수행된다.") {
                shouldNotThrowAny {
                    Validator.validateParserStr("car1,car2,car3")
                }
            }
        }
    }
})
