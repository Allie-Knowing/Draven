object Dependency {
    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
        const val LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIVE_DATA}"
        const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.VIEWMODEL}"
        const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_FRAGMENT}"
        const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_UI}"
    }

    object Google{
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    }

    object UnitTest {
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
    }

    object AndroidTest {
        const val ANDROID_JUNIT = "androidx.test.ext:junit:${Versions.JUNIT}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    }
}