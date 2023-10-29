package racingcar.domain.race

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import io.mockk.every
import io.mockk.mockkObject
import racingcar.domain.car.Car
import util.RandomNumberGenerator

class RaceTest : BehaviorSpec({
    Given("주어진 자동차가 없을 때") {
        val cars = emptyList<Car>()
        val totalRound = 3

        When("레이스가 생성되면") {
            val result = shouldThrow<IllegalArgumentException> {
                Race(
                    cars = cars,
                    totalRound = totalRound,
                    racePolicy = RandomRacePolicy,
                )
            }

            Then("IllegalArgumentException이 발생한다") {
                result shouldHaveMessage "Racing game need at least 1 car"
            }
        }
    }

    Given("주어진 라운드가 1보다 작을 때") {
        val cars = listOf(Car(name = "a"))
        val totalRound = 0

        When("레이스가 생성되면") {
            val result = shouldThrow<IllegalArgumentException> {
                Race(
                    cars = cars,
                    totalRound = totalRound,
                    racePolicy = RandomRacePolicy,
                )
            }

            Then("IllegalArgumentException이 발생한다") {
                result shouldHaveMessage "Racing game need at least 1 round"
            }
        }
    }

    Given("레이스가 주어졌을 때") {
        val cars = listOf(Car(name = "a"), Car(name = "a"))
        val totalRound = 3

        val race = Race(
            cars = cars,
            totalRound = totalRound,
            racePolicy = RandomRacePolicy,
        )

        When("레이스가 시작되면") {
            val result = race.start()

            Then("라운드별 자동차들의 레이스 결과와 우승자가 반환된다") {
                result.resultPerRound shouldHaveSize totalRound
                result.resultPerRound.forEach {
                    it shouldHaveSize cars.size
                }
                result.winners shouldHaveAtLeastSize 1
            }
        }
    }

    Given("랜덤 방식의 레이스의 경우") {
        val racePolicy = RandomRacePolicy

        mockkObject(RandomNumberGenerator)

        When("무작위 숫자가 4 이상일 경우") {
            val cars = listOf(Car(name = "a"))
            val totalRound = 1

            val race = Race(
                cars = cars,
                totalRound = totalRound,
                racePolicy = racePolicy,
            )

            every { RandomNumberGenerator.generate(any()) } returns 5

            val result = race.start()

            Then("자동차가 움직인다") {
                result.resultPerRound shouldHaveSize totalRound

                val firstRoundResult = result.resultPerRound.first()
                firstRoundResult shouldHaveSize cars.size

                val firstCarResult = firstRoundResult.first()
                firstCarResult shouldBe 1
            }
        }

        When("무작위 숫자가 4 미만일 경우") {
            val cars = listOf(Car(name = "a"))
            val totalRound = 1

            val race = Race(
                cars = cars,
                totalRound = totalRound,
                racePolicy = racePolicy,
            )

            every { RandomNumberGenerator.generate(any()) } returns 3

            val result = race.start()

            Then("자동차는 움직이지 않는다") {
                result.resultPerRound shouldHaveSize totalRound

                val firstRoundResult = result.resultPerRound.first()
                firstRoundResult shouldHaveSize cars.size

                val firstCarResult = firstRoundResult.first()
                firstCarResult shouldBe 0
            }
        }
    }
})
