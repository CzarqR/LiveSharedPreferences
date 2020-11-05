# LiveSharedPreferences
Android library which enables to easily observe SharedPreferences.

[![](https://jitpack.io/v/CzarqR/LiveSharedPreferences.svg)](https://jitpack.io/#CzarqR/LiveSharedPreferences)


## Setup:
`build.gradle (Project)`:
``` gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
`build.gradle (Module)`:
``` gradle
dependencies {
    ...
    def livesh_version = "1.0"
    implementation "com.github.CzarqR:LiveSharedPreferences:$livesh_version"
}
```

## Usage:

ViewModel:
``` kotlin
val TEST_VALUE_INT = "TEST_VALUE_INT_KEY" to 0 //Pair<key: String, defaultValue: T>

class MainViewModel(
    private val sharedPreferences: SharedPreferences
) : ViewModel()
{
    val testValueInt = sharedPreferences.liveData(TEST_VALUE_INT) // this live data can be observed 
}
```

Now we can observe `testValueInt`.

Activity.kt class which has an instance of `MainViewModel`:
``` kotlin 
viewModel.testValueInt.observe(this, {
    Log.d("MainActivity", "Observed. testValueInt = $it")
})
```

Activity.xml layout with `MainViewModel` variable:
``` xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>
        <variable
            name="viewModel"
            type="com.myniprojects.liveshlib.MainViewModel"/>
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_margin="4dp"
            android:gravity="center"
            android:text="@{viewModel.testValueInt.toString()}"
            android:textSize="18sp"/>
            
    </LinearLayout>
</layout>
```

