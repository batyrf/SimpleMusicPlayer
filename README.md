
# Simple Music Player
Playground for learning new technologies.

## Used technologies:
- [x] [Navigation Component](https://developer.android.com/guide/navigation/navigation-migrate)
- [x] [Dynamic Feature Modules](https://developer.android.com/studio/projects/dynamic-delivery)
- [x] [Gradle Kotlin-DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
- [x] [di - Hilt](https://dagger.dev/hilt/)

## Coming soon:
- [ ] [Paging 3.0](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)
- [ ] [Room](https://developer.android.com/topic/libraries/architecture/room)
- [ ] [Coroutine](https://github.com/Kotlin/kotlinx.coroutines) - [Flow](https://developer.android.com/reference/java/util/concurrent/Flow)
- [ ] [motionlayout](https://developer.android.com/training/constraint-layout/motionlayout)
- [ ] [media bar - android 11](https://developer.android.com/preview/features/media-controls)
- [ ] ui/unit test
- [ ] [ci - github actions](https://github.com/features/actions)

## Data:
Mp3 files are stored on [yandex disk](https://disk.yandex.com) which provides rest api for stored files. With this and already embedded metadatas in mp3 files we can relieve us from the burden of setting up an api. We are using [FFmpegMediaMetadataRetriever](https://github.com/wseemann/FFmpegMediaMetadataRetriever) to extract metadatas. It is slow a process but we will bare with that for now.

## Open for corrections and suggestions!
