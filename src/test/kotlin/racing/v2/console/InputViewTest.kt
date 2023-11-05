package racing.v2.console

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racing.v2.domain.Car
import racing.v2.view.InputView

class InputViewTest : StringSpec({
    "자동차 이름들은 쉽표(,)를 기준으로 구분된다." {
        val cars: List<Car> = InputView.validateCars("pobi,crong,honux,alex")
        cars.size shouldBe 4
    }

    "자동차 이름이 입력되지 않으면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            InputView.validateCars(null)
        }.message shouldBe "자동차 이름을 쉼표(,) 기준으로 구분해서 입력해주세요."
    }

    "시도할 횟수가 입력되지 않으면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            InputView.validateTryCount(null)
        }.message shouldBe "시도할 횟수는 숫자로 입력해주세요."
    }

    "시도할 횟수가 숫자가 아닌 문자로 입력되면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            InputView.validateTryCount("숫자아님")
        }.message shouldBe "시도할 횟수는 숫자로 입력해주세요."
    }
})
