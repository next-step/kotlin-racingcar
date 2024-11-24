package car.domain

import car.canMovePossibilityFixtures
import car.canNotMovePossibilityFixtures
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarRacingGameTest : StringSpec(
    {
        "자동차 경주 게임을 실행하여 최종 결과를 도출한다." {
            val sut = CarRacingGame(
                cars = listOf(
                    Car(name = "car1"),
                    Car(name = "car2"),
                    Car(name = "car3"),
                ),
                totalRound = 2,
                movePossibilities = listOf(
                    MovePossibilities(
                        listOf(
                            canMovePossibilityFixtures(),
                            canNotMovePossibilityFixtures(),
                            canNotMovePossibilityFixtures(),
                        )
                    ),
                    MovePossibilities(
                        listOf(
                            canMovePossibilityFixtures(),
                            canMovePossibilityFixtures(),
                            canNotMovePossibilityFixtures(),
                        )
                    ),
                ),
            )

            val actual = sut.play()

            actual shouldBe CarRacingGameResult(
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
                            MovedCar(
                                position = 0,
                                name = "car3",
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
                            MovedCar(
                                position = 0,
                                name = "car3",
                            ),
                        )
                    ),
                ),
            )

            actual.winners shouldBe listOf("car1")
        }
    }
)