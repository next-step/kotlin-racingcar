# kotlin-racingcar

1. kotlin require(), check()를 통해 코드 제한을 걸 수 있다.
    require()   -> 타입 시스템을 활용해서 argument에 제한을 거는 코드를 많이 사용한다. 
                    ex) 입력을 받을 때 값이 정상적으로 입력이 되었는지 / validation 체크
    check()     -> 어떤 구체적인 조건을 만족할 때 함수를 사용할 수 있게 할때 많이 사용한다.
                    ex) 사용자가 로그인 했을 때만 처리되도록 / 객체를 사용할 수 있는 시점에 사용하도록

2. 연산자들을 Enum으로 추출 / 객체지향 생활 체조 원칙에 따라 if,else 제거!!

3. Enum과 Kotlin High order function 활용 ( 추가 공부 필요 )

4. kotest 활용 ( 추가 공부 필요 )

5. try catch 대신에 kotlin runCatching {}.onFailure 활용