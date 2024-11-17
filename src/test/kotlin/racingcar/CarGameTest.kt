package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarGameTest : StringSpec({
    "게임 진행을 위해 입력받는 숫자들이 음수라면 게임이 생성되지 않고 예외를 반환한다." {
        forAll(
            row(0, 3),
            row(-1, 4),
            row(2, 0),
            row(2, -1),
            row(-1, -1),
        ) { carCount, repeatCount ->
            shouldThrow<IllegalArgumentException> {
                CarGame(carCount, repeatCount, FixedNumberGenerator(4))
            }
        }
    }

    "게임 생성 시 참여하는 차량 대수와 진행할 회차가 입력받은 값으로 설정된다. " {
        val game = CarGame(3, 5, FixedNumberGenerator(4))
        game.cars.size shouldBe 3
        game.currentPhase shouldBe 5
    }

    "게임이 진행될때마다 현재 회차값이 1씩 감소한다." {
        val game = CarGame(3, 5, FixedNumberGenerator(4))
        (4 downTo 1).forEach { phase ->
            game.playSinglePhase()
            game.currentPhase shouldBe phase
        }
    }

    "게임이 종료된 이후는 경주를 실행할 수 없습니다." {
        val game = CarGame(3, 1, FixedNumberGenerator(4))
        game.playSinglePhase()
        shouldThrow<IllegalStateException> {
            game.playSinglePhase()
        }
    }

    "회차를 진행할 때 4 이상의 숫자가 전달된 차량은 한칸 전진한다." {
        val game = CarGame(3, 5, FixedNumberGenerator(4))
        game.playSinglePhase()
        game.cars.forEach { car -> car.moveCount shouldBe 1 }
    }

    "회차를 진행할 때 4 미만의 숫자가 전달된 차량은 전진하지 못한다." {
        val game = CarGame(3, 5, FixedNumberGenerator(3))
        game.playSinglePhase()
        game.cars.forEach { car -> car.moveCount shouldBe 0 }
    }
})
