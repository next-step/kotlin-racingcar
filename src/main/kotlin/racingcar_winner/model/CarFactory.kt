package racingcar_winner.model

class CarFactory {

    fun orderMakingCars(carNames: List<String>): Cars {
        return Cars(
            carNames.map { name ->
                createCar(name)
            })

    }

    private fun checkNameLength(name: String) {
        if (name.length > 5) throw IllegalArgumentException("# 이름의 길이가 5자보다 길 수 없습니다. 현재이름: $name")
    }

    private fun createCar(name: String): Car {
        checkNameLength(name)
        return Car(name)
    }
}
