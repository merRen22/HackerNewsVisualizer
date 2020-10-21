# HackerNews Visualizer

This project shows a list from post in hackerNews an shows them in a webview. The user also has the obtion to view the latest visualize post offline and banned a post from showing again

![alt text](https://raw.githubusercontent.com/merRen22/HackerNewsVisualizer/main/showcase/v1.1.png)
![alt text](https://raw.githubusercontent.com/merRen22/HackerNewsVisualizer/main/showcase/v1.2.png)

## Used Libraries
 - [Navigation](https://developer.android.com/topic/libraries/architecture/navigation) (Fragment transitions)
 - [View Binding](https://developer.android.com/topic/libraries/view-binding) (Bind views)
 - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) (Store and manage UI-related data)
 - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)  (Observable data)
 - [Kotlin Coroutine](https://github.com/Kotlin/kotlinx.coroutines) (Light-weight threads)
 - [Dagger2](https://github.com/google/dagger) (Dependency Injection)
 - [Room](https://developer.android.com/topic/libraries/architecture/room) (Abstraction layer over SQLite)
 - [Retrofit](https://github.com/square/retrofit) (HTTP client)

## Architecture

This app uses MVVM architecture and follows the guildline shown [here](https://developer.android.com/jetpack/docs/guide).

This is also a single-activity application. All screen transitions are done by [Navigation](https://developer.android.com/guide/navigation?hl=en).
