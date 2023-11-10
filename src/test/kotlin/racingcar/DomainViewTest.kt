package racingcar

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Car
import racingcar.domain.RacingGameResult
import racingcar.view.state

class DomainViewTest : FunSpec({
    test("자동차의 상태를 출력하면 이름, 위치가 함께 출력된다.") {
        val car = Car(name = "hojun", location = 3)
        car.state() shouldBe "hojun : ---"
    }

    test("자동차게임결과의 상태를 출력하면 모든 자동차의 이름, 위치가 함께 출력된다.") {
        val racingGameResult = RacingGameResult(
            listOf(
                Car(location = 0, name = "pobi"),
                Car(location = 1, name = "crong"),
                Car(location = 2, name = "honux"),
                Car(location = 3, name = "hojun")
            )
        )
        racingGameResult.state() shouldBe """
            pobi : 
            crong : -
            honux : --
            hojun : ---
            
        """.trimIndent()
    }
})
