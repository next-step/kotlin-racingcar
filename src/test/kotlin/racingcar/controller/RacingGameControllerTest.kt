package racingcar.controller

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.StringSpec
import io.mockk.every
import io.mockk.mockkObject
import racingcar.domain.strategy.RandomMoveStrategy
import racingcar.utils.Reader

internal class RacingGameControllerTest : StringSpec({
    "MoveStrategy가 주어지면 게임을 진행할 수 있다." {
        mockkObject(Reader)
        shouldNotThrowAny {
            every { Reader.read() }.returnsMany("a,b,c", "2")
            RacingGameController.play(RandomMoveStrategy())
        }
    }
})
