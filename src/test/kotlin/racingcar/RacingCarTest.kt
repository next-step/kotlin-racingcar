package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Car
import racingcar.domain.CarResult
import racingcar.domain.GameResults
import racingcar.domain.RacingCarGame
import racingcar.domain.SeedMaker
import racingcar.domain.SeedMakerImpl

class RacingCarTest {
    @ParameterizedTest
    @ValueSource(ints = [3, 5, 10])
    fun `입력 대수만큼 자동차를 생성하는지 테스트`(input: Int) {
        val defaultTrial = 1
        val defaultSeedMaker = SeedMakerImpl()
        val inputCars = List(input) { "name$it" }
        val game = RacingCarGame(defaultTrial, defaultSeedMaker, inputCars)
        game.play()

        repeat(input) {
            val carSize = game.getGameHistory().first().size

            assertThat(carSize).isEqualTo(input)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 5, 10])
    fun `입력 시도횟수만큼 게임을 진행하는지 테스트`(input: Int) {
        val defaultCar = listOf("name")
        val defaultSeedMaker = SeedMakerImpl()
        val game = RacingCarGame(input, defaultSeedMaker, defaultCar)
        game.play()

        val carSize = game.getGameHistory().size

        assertThat(carSize).isEqualTo(input)
    }

    @Test
    fun `4이상의 시드에만 이동하는지 테스트`() {
        val defaultTrial = 10
        val carName = "name"
        val defaultCar = listOf(carName)
        val testList = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

        val mockingSeedMaker: SeedMaker = object : SeedMaker {
            var top = -1

            override fun nextInt(): Int {
                return testList[++top]
            }
        }

        val game = RacingCarGame(defaultTrial, mockingSeedMaker, defaultCar)
        game.play()

        val result = game.getGameHistory().last()[0].position
        val expectPosition = testList.filter { it >= 4 }.size
        assertThat(result).isEqualTo(expectPosition)
    }

    @Test
    fun `1명 우승자일 경우 우승자가 맞는지에 대한 테스트`() {
        val stopSeed: SeedMaker = object : SeedMaker {
            override fun nextInt(): Int {
                return 1
            }
        }
        val goSeed: SeedMaker = object : SeedMaker {
            override fun nextInt(): Int {
                return 8
            }
        }
        val loser = Car("loser", stopSeed).also {
            it.proceed()
        }
        val winner = Car("winner", goSeed).also {
            it.proceed()
        }

        val gameResults = GameResults()
        val winnerResult = gameResults.getWinnerResult(listOf(loser, winner))

        assertThat(winnerResult).isEqualTo(listOf(winner.name))
    }

    @Test
    fun `여러명 우승자에 대한 테스트`() {
        val goSeed: SeedMaker = object : SeedMaker {
            override fun nextInt(): Int {
                return 8
            }
        }
        val car1 = Car("car1", goSeed).also {
            it.proceed()
        }
        val car2 = Car("car2", goSeed).also {
            it.proceed()
        }

        val gameResults = GameResults()
        val winnerResult = gameResults.getWinnerResult(listOf(car1, car2))

        assertThat(winnerResult).isEqualTo(listOf(car1.name, car2.name))
    }

    @Test
    fun `Car 객체가 4이상의 시드에만 이동하는지 테스트`() {
        val mockingSeedMaker: SeedMaker = object : SeedMaker {
            override fun nextInt(): Int {
                return 5
            }
        }
        val car = Car("name", mockingSeedMaker)
        car.proceed()

        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `Car로 부터 CarResult가 알맞는 정보로 만들어지는지 테스트`() {
        val mockingSeedMaker: SeedMaker = object : SeedMaker {
            override fun nextInt(): Int {
                return 5
            }
        }
        val car = Car("name", mockingSeedMaker)
        car.proceed()

        val carResult = CarResult.of(car)

        assertThat(carResult.name).isEqualTo(car.name)
        assertThat(carResult.position).isEqualTo(car.position)
    }

    @Test
    fun `GameResults가 진행상황을 잘 기록하는지 테스트`() {
        val goSeed: SeedMaker = object : SeedMaker {
            override fun nextInt(): Int {
                return 8
            }
        }
        val car1 = Car("car1", goSeed).also {
            it.proceed()
        }
        val car2 = Car("car2", goSeed).also {
            it.proceed()
            it.proceed()
        }

        val gameResults = GameResults()
        gameResults.record(listOf(car1, car2))
        val gameHistory = gameResults.gameHistory.first()

        val expectHistory = listOf(
            CarResult("car1", 1),
            CarResult("car2", 2)
        )

        assertThat(gameHistory).isEqualTo(expectHistory)
    }
}
