# kotlin-racingcar

# step 2 문자열 계산기 리뷰
1. kotlin require(), check()를 통해 코드 제한을 걸 수 있다.
    require()   -> 타입 시스템을 활용해서 argument에 제한을 거는 코드를 많이 사용한다. 
                    ex) 입력을 받을 때 값이 정상적으로 입력이 되었는지 / validation 체크
    check()     -> 어떤 구체적인 조건을 만족할 때 함수를 사용할 수 있게 할때 많이 사용한다.
                    ex) 사용자가 로그인 했을 때만 처리되도록 / 객체를 사용할 수 있는 시점에 사용하도록

2. 연산자들을 Enum으로 추출 / 객체지향 생활 체조 원칙에 따라 if,else 제거!!

3. Enum과 Kotlin High order function 활용 ( 추가 공부 필요 )

4. kotest 활용 ( 추가 공부 필요 )

5. try catch 대신에 kotlin runCatching {}.onFailure 활용

# step 3 자동차 경주 리뷰
1. 생성 즉시 초기화 init {} 블럭 사용

2. 불변 컬렉션 활용 - 가변성 제한

3. public 사용 제한 - private 적극 사용

# step 4 자동차 경주 (우승자) 구현 기능 목록
1. 자동차 입력 값 , 구분하기

2. 자동차 경주 내역 출력할 때 자동차 이름 같이 출력

3. 자동차에 이름 부여해서 생성 (자동차 이름 5글자 제한)

4. 우승자 출력(한명 이상일 수 있음)