package racingcar.component

import racingcar.Car
import racingcar.CarFactory
import racingcar.CarName
import racingcar.CarNameSplitter
import racingcar.dto.CarCreateDto
import racingcar.store.CarStore
import racingcar.ui.Input
import racingcar.ui.Span

class CarInputComponent : Component {
    private val span = Span(text = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", block = true)
    private val input = Input()

    init { this.input.addCommandListener(this::onCommand) }

    fun onCommand(value: String) {
        val carNames = CarNameSplitter.execute(target = value)
        val cars = this.createCars(carNames = carNames)
        CarStore.saveAll(cars)
    }

    private fun createCars(carNames: List<CarName>): List<Car> {
        val createDtos = carNames.map { CarCreateDto(name = it) }
        return CarFactory.createMany(dtos = createDtos)
    }

    override fun render() {
        this.span.draw()
        this.input.draw()
    }
}
