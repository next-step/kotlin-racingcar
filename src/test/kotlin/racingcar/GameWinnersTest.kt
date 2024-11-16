package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class GameWinnersTest : StringSpec({
    "자동차들(Cars) 중에서 가장 멀리 간 자동차들의 이름을 가진다." {
        val cars =
            Cars(
                listOf(
                    Car(CarName("good"), CarPosition(3)),
                    Car(CarName("dino"), CarPosition(2)),
                    Car(CarName("bad"), CarPosition(1)),
                    Car(CarName("dino"), CarPosition(3)),
                ),
            )
        val gameWinners = GameWinners(cars)
        gameWinners.names shouldBe listOf("good", "dino")
    }
})
