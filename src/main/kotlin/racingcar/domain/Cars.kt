package racingcar.domain

class Cars(val cars: List<Car>) {
    fun play(numberPicker: RandomNumberPicker) {
        cars.forEach { car -> car.move(numberPicker.getNumber()) }
    }
}