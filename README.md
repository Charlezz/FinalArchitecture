# Final Architecture
# MVVM + Databinding + Dagger2 + Paging + AAC ViewModel + LiveData + Retrofit + Room + Photo Query
# Kotlin Version + Java Version


이 가이드는 이미 기초적인 안드로이드앱을 만들줄 알고,구조적인면에서 더 나은 앱을 만들기를 원하는 개발자를 위한 글입니다.

애플리케이션을 만들다보면 초기에는 어찌어찌 돌아는 가는데, 기능을 추가하고 업데이트를 하면 할 수록 유지보수가 힘들어 지는 것을 느낄수 있습니다. 어디부터 어디까지 손을봐야 할지... 한군데를 건드렸더니 이곳 저곳에서 터지는 사이드이펙트...
구조적인 면부터 수정하지 않으면 점점 더 유지보수가 힘들어 질 것입니다.



### 구조 개선을 위한 원칙들

**첫째**, Activity와 Fragment같은 UI컨트롤러에 너무 많은 코드를 작성하면 안됩니다. 일반적으로 하는 실수가 바로 이러한 UIController에 모든 코드를 다 작성하는것입니다. UIController에는 생명주기가 존재하고 이를 관리하는것은 굉장히 까다롭습니다. Android OS는 사용자와 상호작용에서 메모리부족 또는 다른 요인에 의해서 언제든지 UIController를 파괴 시킬 수 있으므로 견고한 앱을 만들고자한다면 UIController와의 의존성을 최소화하는것이 가장 좋습니다.

**둘째**, 데이터를 유지하는것입니다. 네트워크가 중간에 유실되었다면, 네트워크 상태가 복구되는데로 다음 데이터를 받아올 수 있어야 합니다. UI Controller가 Android OS에 의해 파괴되더라도 데이터를 유지하고 있어야 합니다. 흔히 Model이라 부르는것이 이러한 역할을 해야하며, View와 앱 컴포넌트로부터 독립적이여야 합니다. 

기본적인 위의 두가지 원칙만 잘 지킨다면 기본적인 유닛 테스트가 가능해집니다. 유닛테스트가 가능하다는것은 컴포넌트간의 의존성이 낮고, 독립적임을 뜻합니다. 이는 앱품질을 높여주고, 좀 더 유연하게 변화에 대처할 수 있음을 뜻합니다.  자세한것은 Dagger2 포스팅을 확인하시기 바랍니다.

### 앱 아키텍처를 위한 라이브러리들

추가적인 라이브러리 적용없이도 애플케이션의 구조를 잡을수는 있지만, 보통은 아래와 같은 라이브러리 등을 사용하여 앱 구조를 잡습니다.



- [DataBinding](https://developer.android.com/topic/libraries/data-binding/?hl=ko) : UI요소들과 Observable한 데이터의 바인딩을 도와주는 라이브러리
- [Lifecycles](https://developer.android.com/reference/android/arch/lifecycle/Lifecycle) :  액티비티와 프레그먼트의 생명주기를 관리
- [LiveData](http://www.charlezz.com/?p=363) : 데이터의 변경을 감지 할 수 있으며, View에게 변경 이벤트 전달.
- [Paging](http://www.charlezz.com/?p=484) : Datasource로 부터 데이터를 점진적으로 로딩한다.
- [Room](http://www.charlezz.com/?p=368) : SQLite를 좀 더 편리하고, 유연하게 사용가능하게 한다.
- [ViewModel](http://www.charlezz.com/?p=365) : UIController의 생명주기를 알고있으며, 뷰에게 제공할 데이터를 관리한다.
- [Dagger2](http://www.charlezz.com/?p=428) : 객체의 생성을 담당하며 Activity나 Fragment의 생명주기에 맞게 인스턴스를 주입하고 관리한다.





### 최종적인 앱 구조의 형태


![final-architecture](http://www.charlezz.com/wordpress/wp-content/uploads/2018/08/final-architecture.png)



로컬데이터는 Room을 이용하여 로컬DB로부터 관리되고, 원격으로부터 얻는 데이터는 레트로핏을 통해 얻어진다. 앱내에서 필요한 모든 데이터들은 Repository에서 관리하게 되고, ViewModel은 필요한 데이터들을 Repository로부터 LiveData의 형태로 얻어서 관리하게 되며, 액티비티나 프레그먼트가 onDestroy되기전까지 데이터를 보관한다. 액티비티나 프레그먼트에서는 DataBinding을 통해 최종적으로 뷰모델로부터 제공받은 LiveData를 통해 UI를 갱신하게 된다.


[블로그](http://www.charlezz.com/?p=627)에서 더 자세한 정보를 확인해 보실 수 있습니다.
