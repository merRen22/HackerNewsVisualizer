object Config {

    object Version {

        const val navigation = "2.2.2"

        const val dagger = "2.24"

        const val retrofit = "2.8.1"
        const val retrofitConverter = "2.8.1"
        const val room = "2.2.5"
    }

    val appId = "com.hacker.hackernewsvisualizer"
    val versionCode = 1
    val versionName = "1.0"

    val compileSdkVersion = 29
    val minSdkVersion = 19
    val targetSdkVersion =29

    val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Dependencies.kotlin_version}"
    val androidxCore = "androidx.core:core-ktx:1.3.2"
    val androidxCompat = "androidx.appcompat:appcompat:1.2.0"
    val androidxConstraintLayout = "androidx.constraintlayout:constraintlayout:2.0.2"
    val testImplementation = "junit:junit:4.12"
    val testJUnit = "androidx.test.ext:junit:1.1.2"
    val testEspresso = "androidx.test.espresso:espresso-core:3.3.0"

    // navigation
    val navCommonKtx = "androidx.navigation:navigation-common-ktx:${Version.navigation}"
    val navRuntimeKtx = "androidx.navigation:navigation-runtime-ktx:${Version.navigation}"
    val navFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"

    // dependency injection
    val dagger = "com.google.dagger:dagger:${Version.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.dagger}"
    val daggerAndroid = "com.google.dagger:dagger-android:${Version.dagger}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Version.dagger}"
    val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Version.dagger}"

    // network
    val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    val retrofitConverter = "com.squareup.retrofit2:converter-moshi:${Version.retrofitConverter}"

    // database
    val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    val roomCompiler = "androidx.room:room-compiler:${Version.room}"
    val roomKtx = "androidx.room:room-ktx:${Version.room}"

    // desugar
    val desugar = "com.android.tools:desugar_jdk_libs:1.0.5"
}
