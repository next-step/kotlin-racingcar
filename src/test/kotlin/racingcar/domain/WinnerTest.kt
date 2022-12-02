package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.vo.Name

class WinnerTest : FunSpec({
    context("객체 생성") {
        test("자동차를 입력받아 객체를 생성한다.") {
            shouldNotThrowAny {
                Winner(Car("win1"))
            }
        }
    }

    context("name()") {
        test("이름을 반환한다.") {
            val name = "win1"
            val winner = Winner(Car(name))

            winner.name() shouldBe Name(name)
        }
    }
})
