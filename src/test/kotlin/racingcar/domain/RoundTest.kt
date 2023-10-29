package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class RoundTest : ExpectSpec({

    expect("1 이상 100 이하의 정수만을 가질 수 있다.") {
        val gameRound1 = GameRound(1)
        gameRound1.totalRound shouldBe 1

        val gameRound2 = GameRound(100)
        gameRound2.totalRound shouldBe 100
    }

    expect("0 이하의 음수를 입력하면 오류가 발생한다.") {
        shouldThrowExactly<IllegalArgumentException> {
            GameRound(-1)
        }
    }

    expect("총 라운드가 종료되면 isFinished 는 true 를 반환한다.") {
        val gameRound = GameRound(2)
        val cars = listOf(RacingCar())

        gameRound.next(cars)
        gameRound.next(cars)

        gameRound.isFinished() shouldBe true
    }

    expect("총 라운드가 종료되지 않으면 isFinished 는 flase 를 반환한다.") {
        val gameRound = GameRound(2)
        val cars = listOf(RacingCar())

        gameRound.next(cars)

        gameRound.isFinished() shouldBe false
    }

    expect("라운드 결과는 라운드 진행 횟수만큼 기록된다.") {
        val totalRound = 10
        val gameRound = GameRound(totalRound)
        val cars = listOf(RacingCar())

        repeat(totalRound) { gameRound.next(cars) }

        gameRound.getResults().size shouldBe totalRound
    }
})
