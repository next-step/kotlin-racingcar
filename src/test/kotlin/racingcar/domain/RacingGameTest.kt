package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

class RacingGameTest: StringSpec({

    "자동차와 라운드 수를 입력받아 게임을 플레이 할 수 있다." {
        val cars = Cars(
            listOf(
                Car(FixedEngine(5), "test1"),
                Car(FixedEngine(3), "test2"),
                Car(FixedEngine(8), "test3")
            )
        )

        val racingGame = RacingGame(cars, 1)
        racingGame.play()

        racingGame.isFinished() shouldBe true
        val racingGameCars = racingGame.getCars()
        racingGameCars[0].position shouldBe 1
        racingGameCars[1].position shouldBe 0
        racingGameCars[2].position shouldBe 1
    }
})