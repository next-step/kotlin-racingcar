package calculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class BasicOperationsCalculatorKoTest : BehaviorSpec({

    val basicOperationsCalculator = BasicOperationsCalculator()

    given("BasicOperationsCalculator"){
        val firstNum : Double = 10.0
        val secondNum : Double = 5.0
        `when`("더하면"){
            val result = basicOperationsCalculator.operation(firstNum, secondNum, "+")
            then("15.0"){
                result shouldBe 15.0
            }
        }

        `when`("빼면"){
            val result = basicOperationsCalculator.operation(firstNum, secondNum, "-")
            then("5.0"){
                result shouldBe 5.0
            }
        }

        `when`("곱하면"){
            val result = basicOperationsCalculator.operation(firstNum, secondNum, "*")
            then("50.0"){
                result shouldBe 50.0
            }
        }

        `when`("나누면"){
            val result = basicOperationsCalculator.operation(firstNum, secondNum, "/")
            then("2.0"){
                result shouldBe 2.0
            }
        }
    }
})