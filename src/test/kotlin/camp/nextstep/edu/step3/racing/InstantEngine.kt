package camp.nextstep.edu.step3.racing

import io.kotest.core.spec.style.ShouldSpec
import org.assertj.core.api.Assertions.assertThat

class InstantEngine(n: Int) : Car.Engine {
    private val movables = mutableListOf<Int>()

    init {
        repeat(n) {
            movables.add(MOVABLE_SPEED)
        }
    }

    override fun speed(): Int {
        return if (movables.isNotEmpty()) movables.removeFirst()
        else NOT_MOVABLE_SPEED
    }

    companion object {
        private const val MOVABLE_SPEED = 9
        private const val NOT_MOVABLE_SPEED = 0
    }
}

class InstantEngineTests : ShouldSpec({
    should("0번 움직일 수 있는 엔진은 speed 메서드 호출시 매번 움직일 수 없는 값을 리턴해야 한다.") {
        val moveTwiceEngine = InstantEngine(0)

        assertThat(moveTwiceEngine.speed()).isLessThan(4)
        assertThat(moveTwiceEngine.speed()).isLessThan(4)
        assertThat(moveTwiceEngine.speed()).isLessThan(4)
        assertThat(moveTwiceEngine.speed()).isLessThan(4)
    }

    should("2번 움직일 수 있는 엔진은 speed 메서드 호출시 2번 움직일 수 있는 값을 리턴해야 한다.") {
        val moveTwiceEngine = InstantEngine(2)

        assertThat(moveTwiceEngine.speed()).isGreaterThanOrEqualTo(4)
        assertThat(moveTwiceEngine.speed()).isGreaterThanOrEqualTo(4)
        assertThat(moveTwiceEngine.speed()).isLessThan(4)
        assertThat(moveTwiceEngine.speed()).isLessThan(4)
    }

    should("5번 움직일 수 있는 엔진은 speed 메서드 호출시 5번 움직일 수 있는 값을 리턴해야 한다.") {
        val moveTwiceEngine = InstantEngine(5)

        assertThat(moveTwiceEngine.speed()).isGreaterThanOrEqualTo(4)
        assertThat(moveTwiceEngine.speed()).isGreaterThanOrEqualTo(4)
        assertThat(moveTwiceEngine.speed()).isGreaterThanOrEqualTo(4)
        assertThat(moveTwiceEngine.speed()).isGreaterThanOrEqualTo(4)
        assertThat(moveTwiceEngine.speed()).isGreaterThanOrEqualTo(4)
        assertThat(moveTwiceEngine.speed()).isLessThan(4)
    }
})
