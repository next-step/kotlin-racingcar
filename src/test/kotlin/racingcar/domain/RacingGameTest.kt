package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import racingcar.test.RacingCarGenerator

class RacingGameTest : BehaviorSpec({

    given("FORWARD 를 반환하는 게임 룰을 설정했을 때") {
        val gameRule = FixedGameRule(MovingDirection.FORWARD)

        `when`("AA 사용자가 1 라운드를 진행하면") {
            val nickname = Nickname("AA")
            val cars = listOf(RacingCarGenerator.create(nickname))
            val racingGame = RacingGame(cars, gameRule, 1)
            racingGame.start()

            then("1라운드 자동차 포지션은 1이다.") {
                val roundResults = racingGame.getRoundResults()

                roundResults[0].cars.forEach { it.position shouldBe Position(1) }
            }

            then("우승자는 AA 이다.") {
                val winners = racingGame.getWinners()

                winners.size shouldBe 1
                winners[0].nickname shouldBe nickname
            }
        }

        `when`("AA, BB 사용자가 10 라운드를 진행하면") {
            val nickname1 = Nickname("AA")
            val nickname2 = Nickname("BB")
            val cars = listOf(RacingCarGenerator.create(nickname1), RacingCarGenerator.create(nickname2))
            val racingGame = RacingGame(cars, gameRule, 10)
            racingGame.start()

            then("라운드마다 포지션이 1씩 증가한다.") {
                val roundResults = racingGame.getRoundResults()

                roundResults.forEachIndexed { idx, roundResult ->
                    roundResult.cars.forEach { it.position shouldBe Position(idx + 1) }
                }
            }

            then("우승자는 AA, BB 이다.") {
                val winners = racingGame.getWinners()

                winners.size shouldBe 2
                winners.find { it.nickname == nickname1 } shouldNotBe null
                winners.find { it.nickname == nickname2 } shouldNotBe null
            }
        }
    }

    given("호출 횟수가 3의 배수일 때 전진하는 게임룰을 설정했을 때") {
        val gameRule = ConditionGameRule { it % 3 == 0 }

        `when`("AA, BB, CC 사용자가 10 라운드를 진행하면") {
            val cars = listOf(
                RacingCarGenerator.create(Nickname("AA")),
                RacingCarGenerator.create(Nickname("BB")),
                RacingCarGenerator.create(Nickname("CC")),
            )
            val racingGame = RacingGame(cars, gameRule.apply { count = 0 }, 10)
            racingGame.start()

            then("우승자는 CC 이다.") {
                racingGame.getWinners().size shouldBe 1
                racingGame.getWinners()[0].nickname shouldBe Nickname("CC")
            }
        }


        `when`("AA, BB, CC, DD 사용자가 1 라운드를 진행하면") {
            val cars = listOf(
                RacingCarGenerator.create(Nickname("AA")),
                RacingCarGenerator.create(Nickname("BB")),
                RacingCarGenerator.create(Nickname("CC")),
                RacingCarGenerator.create(Nickname("DD")),
            )
            val racingGame = RacingGame(cars, gameRule.apply { count = 0 }, 1)
            racingGame.start()

            then("우승자는 CC 이다.") {
                racingGame.getWinners().size shouldBe 1
                racingGame.getWinners()[0].nickname shouldBe Nickname("CC")
            }
        }

        `when`("AA, BB, CC, DD 사용자가 2 라운드를 진행하면") {
            val cars = listOf(
                RacingCarGenerator.create(Nickname("AA")),
                RacingCarGenerator.create(Nickname("BB")),
                RacingCarGenerator.create(Nickname("CC")),
                RacingCarGenerator.create(Nickname("DD")),
            )
            val racingGame = RacingGame(cars, gameRule.apply { count = 0 }, 2)
            racingGame.start()

            then("우승자는 BB, CC 이다.") {
                racingGame.getWinners().size shouldBe 2
                racingGame.getWinners()[0].nickname shouldBe Nickname("BB")
                racingGame.getWinners()[1].nickname shouldBe Nickname("CC")
            }
        }
    }
})
