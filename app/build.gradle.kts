plugins{
    id(Dependencies.androidApp)
    kotlin(Dependencies.kotlinAndroid)
    kotlin(Dependencies.kotlinExtensions)
    kotlin(Dependencies.kapt)
}

android {
    compileSdkVersion(Config.compileSdkVersion)

    buildFeatures.dataBinding = true

    defaultConfig {
        multiDexEnabled = true
        applicationId = Config.appId
        versionCode = Config.versionCode
        versionName = Config.versionName

        minSdkVersion(Config.minSdkVersion)
        targetSdkVersion(Config.targetSdkVersion)
        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        coreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Config.kotlinStdlib)
    implementation(Config.androidxCore)
    implementation(Config.androidxCompat)
    implementation(Config.androidxConstraintLayout)
    testImplementation(Config.testImplementation)
    androidTestImplementation(Config.testJUnit)
    androidTestImplementation(Config.testEspresso)

    //Navigation
    implementation(Config.navCommonKtx)
    implementation(Config.navRuntimeKtx)
    implementation(Config.navFragmentKtx)
    implementation(Config.navUiKtx)

    // dependency injection
    implementation(Config.dagger)
    implementation(Config.daggerAndroid)
    implementation(Config.daggerAndroidSupport)
    kapt(Config.daggerCompiler)
    kapt(Config.daggerAndroidProcessor)

    // network
    implementation(Config.retrofit)
    implementation(Config.retrofitConverter)

    //database
    implementation(Config.roomRuntime)
    kapt(Config.roomCompiler)
    implementation(Config.roomKtx)

    coreLibraryDesugaring(Config.desugar)
}