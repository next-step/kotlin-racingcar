package racingcar.component

import racingcar.CarFactory
import racingcar.CarGroup
import racingcar.CarName
import racingcar.CarNameSplitter
import racingcar.dto.CarCreateDto
import racingcar.store.CarGroupStore
import racingcar.ui.Input
import racingcar.ui.Span

class CarNameInputComponent : Component {
    private val span = Span(text = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", block = true)
    private val input = Input()

    init { this.input.addCommandListener(this::onCommand) }

    fun onCommand(value: String) {
        val carNames = CarNameSplitter.execute(target = value)
        val carGroup = this.createCarGroup(carNames = carNames)
        CarGroupStore.setState(state = carGroup)
    }

    private fun createCarGroup(carNames: List<CarName>): CarGroup {
        val createDtos = carNames.map { CarCreateDto(name = it) }
        val cars = CarFactory.createMany(dtos = createDtos)
        return CarGroup(cars = cars)
    }

    override fun render() {
        this.span.draw()
        this.input.draw()
    }
}
