package step3.component

import step3.CarFactory
import step3.CarNameSplitter
import step3.CarStore
import step3.dto.CarCreateDto
import step3.ui.Input
import step3.ui.Span

class CarInputComponent : Component {
    private val span = Span(text = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", block = true)
    private val input = Input()

    init { this.input.addCommandListener(this::onCommand) }

    fun onCommand(value: String) {
        val carNames = CarNameSplitter.execute(target = value)
        val createDtos = carNames.map { CarCreateDto(name = it) }
        val cars = CarFactory.createMany(dtos = createDtos)
        CarStore.saveAll(cars)
    }

    override fun render() {
        this.span.draw()
        this.input.draw()
    }
}
