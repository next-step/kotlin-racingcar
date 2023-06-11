### Step 4. 요구사항

- 차 이름 추상화 (5자 제한)
- 차 이름은 쉼표(,)를 기준으로 구분
- 차 이름 리스트 일급 컬렉션으로 추상화
- 차 이름에 따른 위치 기록
- 차들의 기록과 우승자를 제공 (우승자는 한 명 이상)
- 전진하는 차를 출력할 때 차 이름을 같이 출력

### Step 5. 요구사항

#### 패키지 리팩터링

- domain package에서 다른 package 접근 불가
- input, output은 view package로 이동
- controller를 제외한 domain logic이 있는 클래스는 domain package로 이동