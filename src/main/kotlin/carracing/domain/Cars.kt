package carracing.domain

class Cars(var _cars: List<Car>) {

    init {
        require(_cars.size > 1) { "최소 2대 이상의 자동차를 입력해주세요." }
    }

    fun getSize(): Int {
        return _cars.size
    }
}
