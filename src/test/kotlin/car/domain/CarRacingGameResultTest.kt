package car.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarRacingGameResultTest : StringSpec({
    "마지막 라운드에 제일 멀리간 자동차가 우승한다." {
        val sut = CarRacingGameResult(
            listOf(
                RoundResult(
                    listOf(
                        MovedCar(
                            position = 1,
                            name = "car1",
                        ),
                        MovedCar(
                            position = 0,
                            name = "car2",
                        ),
                    )
                ),
                RoundResult(
                    listOf(
                        MovedCar(
                            position = 2,
                            name = "car1",
                        ),
                        MovedCar(
                            position = 1,
                            name = "car2",
                        ),
                    )
                ),
            )
        )

        sut.winners shouldBe listOf("car1")
    }

    "마지막 라운드에 제일 멀리간 자동차가 여러 대인 경우 모두 우승한다." {
        val sut = CarRacingGameResult(
            listOf(
                RoundResult(
                    listOf(
                        MovedCar(
                            position = 0,
                            name = "car1",
                        ),
                        MovedCar(
                            position = 0,
                            name = "car2",
                        ),
                    )
                ),
                RoundResult(
                    listOf(
                        MovedCar(
                            position = 1,
                            name = "car1",
                        ),
                        MovedCar(
                            position = 1,
                            name = "car2",
                        ),
                    )
                ),
            )
        )

        sut.winners shouldBe listOf("car1", "car2")
    }
})
