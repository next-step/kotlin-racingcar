package racingcar.view.store

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.CarName

class StoreTest : FunSpec({
    context("getState 메서드는") {
        test("저장하고 있는 state 를 반환한다.") {
            // given
            CarNameStore.setState(CarName(value = "재혁"))
            // when
            val actual = CarNameStore.getState()
            // then
            actual shouldBe CarName(value = "재혁")
        }
    }

    context("setState 메서드는") {
        test("저장하고 있는 state 를 변경하고 listener 에게 변경을 알린다.") {
            // given
            val listener = {
                val state = CarNameStore.getState()
                state shouldBe CarName(value = "상근")
            }
            CarNameStore.subscribe(listener)
            // when
            CarNameStore.setState(CarName(value = "상근"))
            // then
            CarNameStore.getState() shouldBe CarName(value = "상근")
        }
    }
})

object CarNameStore : Store<CarName>() {
    private var carName = CarName(value = "")

    override fun getState(): CarName {
        return this.carName
    }

    override fun subscribe(listener: Listener): UnSubscribe {
        this.listeners.add(listener)
        return { listeners.remove(listener) }
    }

    override fun setState(state: CarName) {
        this.carName = state
        listeners.forEach { listener -> listener() }
    }
}
