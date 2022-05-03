package study

// data가 들어가면 인자가 똑같다면 동등비교를 할 수 있게 해준다.
data class Person(val name: String, val age: Int, var nickname: String? = name)
