package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingcar.domain.CarTest.Companion.aCar
import racingcar.domain.RacingGame.Companion.createRandomMoveCarRacingGame

class RacingGameTest {

    @Test
    fun `시도 횟수가 1보다 작으면 예외가 발생한다`() {
        val exception = shouldThrowExactly<IllegalArgumentException> {
            RacingGame(attemptCount = 0, cars = Cars(values = listOf(aCar())))
        }
        exception.message shouldBe "게임 생성에 필요한 시도 횟수는 0보다 커야 한다."
    }

    @Test
    fun `게임을 생성할 수 있다`() {
        val actual = RacingGame(attemptCount = 1, cars = Cars(values = listOf(aCar())))

        actual.attemptCount shouldBe 1
        actual.cars shouldHaveSize 1
    }

    @Test
    fun `게임을 실행하면 시도 횟수를 1만큼 차단하고 자동차들을 움직인다`() {
        val racingGame = RacingGame(attemptCount = 1, cars = Cars(values = listOf(aCar(position = 0))))
        racingGame.run()

        racingGame.attemptCount shouldBe 0
        racingGame.cars[0].position shouldBe 1
    }

    @Test
    fun `시도 횟수가 0인데 run하면 예외가 발생한다`() {
        val racingGame = RacingGame(attemptCount = 1, cars = Cars(values = listOf(aCar())))
        racingGame.run()

        val exception = shouldThrowExactly<IllegalStateException> { racingGame.run() }
        exception.message shouldBe "시도 횟수가 남지 않아 게임을 더이상 실행할 수 없다."
    }

    @Test
    fun `시도 횟수와 자동차 이름을 받아 게임을 생성한다`() {
        val actual = createRandomMoveCarRacingGame(attemptCount = 1, listOf("pobi", "crong", "honux"))

        actual.attemptCount shouldBe 1
        actual.cars shouldHaveSize 3
    }

    @Test
    fun `게임이 실행 가능하면 true를 반환한다`() {
        val actual = RacingGame(attemptCount = 1, cars = Cars(values = listOf(aCar()))).isRunnable()
        actual shouldBe true
    }

    @Test
    fun `게임이 실행 불가능하면 false를 반환한다`() {
        val racingGame = RacingGame(attemptCount = 1, cars = Cars(values = listOf(aCar())))
        racingGame.run()

        val actual = racingGame.isRunnable()
        actual shouldBe false
    }

    @Test
    fun `현재 게임의 정보를 반환한다`() {
        val givenPosition = 0
        val givenCarName = CarName(value = "pobi")
        val racingGame = RacingGame(
            attemptCount = 1,
            cars = Cars(values = listOf(aCar(position = givenPosition, carName = givenCarName)))
        )

        val actual = racingGame.currentGameInfo()

        actual[0].first shouldBe givenCarName.value
        actual[0].second shouldBe givenPosition
    }

    @Test
    fun `게임이 종료되지 않았는데 우승자를 확인하면 예외가 발생한다`() {
        val racingGame = RacingGame(attemptCount = 1, cars = Cars(values = listOf(aCar())))

        val exception = shouldThrowExactly<IllegalStateException> { racingGame.winner() }
        exception.message shouldBe "게임이 종료되지 않아 우승자를 확인할 수 없다"
    }

    @Test
    fun `우승자의 이름을 확인할 수 있다`() {
        val racingGame = RacingGame(
            attemptCount = 1,
            cars = Cars(
                values = listOf(
                    aCar(carName = CarName("win1")) { true },
                    aCar(carName = CarName("win2")) { true },
                    aCar(carName = CarName("loser")) { false }
                )
            )
        )
        racingGame.run()

        val actual = racingGame.winner()
        actual shouldContainAll listOf("win1", "win2")
    }
}
