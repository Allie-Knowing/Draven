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

    object Kotlin {
        const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINE}"
    }

    object Google{
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
        const val GOOGLE_OAUTH = "com.google.android.gms:play-services-auth:${Versions.GOOGLE_OAUTH}"
    }

    object Naver{
        const val NAVER_OAUTH = "com.navercorp.nid:oauth:${Versions.NAVER_OAUTH}"
        const val NAVER_OAUTH_JDK = "com.navercorp.nid:oauth-jdk8:${Versions.NAVER_OAUTH}"
    }

    object UnitTest {
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
    }

    object AndroidTest {
        const val ANDROID_JUNIT = "androidx.test.ext:junit:${Versions.JUNIT}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    }
}