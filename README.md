<h1 align="center">Simple Image Gallery</h1></br>
<p align="center">  
An simple image gallery app utilizing Unsplash API to showcase modern Android development architecture (Compose + MVVM + Kotlin + Retrofit2 + Hilt + Coroutines + Kotlin Flow + Jetpack Paging 3) 
</p>
</br>

<p align="center">
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
</p>

## Download
Go to the [Releases](https://github.com/shakil807g/NewzCompose/releases) to download the latest APK.

## Screenshots
<p align="left">
<img src="/demo/device-2021-01-11-125210.gif" width="32%"/>
</p>

# Note
This repo is missing api key for [newsapi](https://newsapi.org)
get the api key from [newsapi](https://newsapi.org) and do following steps
- Add **api_key** property in **local.properties** E.g api_key="54e494XXXXXXXXXXXXXXXXXXXXXXXXXX"

## Tech stack & Open-source libraries
- Minimum SDK level 21
- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- Hilt (alpha) for dependency injection.
- JetPack
  - Paging 3
  - Kotlin Coroutines (https://kotlinlang.org/docs/reference/coroutines-overview.html) (Asynchronous programming)
  - Compose - A modern toolkit for building native Android UI.
  - LiveData - notify domain layer data to views.
  - Lifecycle - dispose observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
  - Moshi - (https://github.com/square/moshi) (Kotlin JSON library for Android from Square)
  - Accompanist - (https://github.com/chrisbanes/accompanist/tree/master/coil) (Image Loading with coil)

- Architecture
  - MVVM Architecture (Declarative View - ViewModel - Model)
  - Repository pattern
