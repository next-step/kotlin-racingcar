package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class ApplicationKtTest : FunSpec({

    context("inputConverter 단위테스트"){
        test("1 이상의 정수로 변환 가능한 입력값에 대한 변환은 성공한다"){
            //given
            forAll(
                row("2", 2),
                row("10", 10),
                row("100", 100)
            ){ input, expected ->
                //when
                val result = input.inputConverter()
                //then
                result shouldBe expected
            }
        }

        test("0 이하의 정수로 변환 가능한 입력값에 대한 변환은 실패한다"){
            forAll(
                row(" "),
                row("0"),
                row("11 "),
                row("-100")
            ){
                shouldThrow<IllegalArgumentException>{
                    it.inputConverter()
                }
            }
        }
    }
    context("validateForm 단위테스트"){
        test("String input에 대해서 Int로 변환 가능한 경우 변환된 Int를 반환"){
            forAll(
                row("10", 10),
                row("0", 0),
                row("-10", -10)
            ){ input, expected ->
                //when
                val result = input.validateForm()
                //then
                result shouldBe expected
            }
        }

        test("String input에 대해서 Int로 변환 불가능한 경우 예외 발생"){
            forAll(
                row(" "),
                row("%"),
                row("11 "),
                row("0.01")
            ){
                shouldThrow<IllegalArgumentException>{
                    it.validateForm()
                }
            }
        }
    }
    context("validateRange 단위테스트"){
        test("1 이상의 정수 input이 주어지면 input을 그대로 반환"){
            forAll(
                row(10, 10),
                row(1, 1),
                row(100, 100)
            ){ input, expected ->
                //when
                val result = input.validateRange()
                //then
                result shouldBe expected
            }
        }

        test("0 이하의 정수 Input이 주어지면 예외 발생"){
            forAll(
                row(0),
                row(-1),
                row(-100),
            ){
                shouldThrow<IllegalArgumentException>{
                    it.validateRange()
                }
            }
        }

    }

})
