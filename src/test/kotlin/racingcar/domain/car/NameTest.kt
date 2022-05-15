package racingcar.domain.car

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class NameTest : FreeSpec({

    "자동차 이름이 ${Name.MAX_LENGTH} 글자를 넘을 경우 예외가 발생한다." - {
        listOf(
            "123456",
            "여섯글자래요",
            "......",
        ).forEach { invalidName ->
            "\"$invalidName\" 은 예외를 발생시킨다." {
                val exception = shouldThrowExactly<IllegalArgumentException> { Name(invalidName) }

                exception.message shouldBe "자동차 이름은 ${Name.MAX_LENGTH} 를 넘을 수 없습니다."
            }
        }
    }

    "자동차 이름이 공백으로만 이루어진 경우 예외가 발생한다." - {
        listOf(
            "",
            " ",
            "      ",
        ).forEach { blankName ->
            "\"$blankName\" 은 예외를 발생시킨다." {
                val exception = shouldThrowExactly<IllegalArgumentException> { Name(blankName) }

                exception.message shouldBe "자동차 이름은 공백만으로 이루어질 수 없습니다."
            }
        }
    }
})
