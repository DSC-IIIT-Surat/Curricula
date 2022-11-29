# Curricula

A warehouse for all the engineering related materials for IIIT Surat students. It aims to later become a hub of all the study and course materials, as a result of contributions made by other fellow aspiring engineers.</string>


## Installation

How to install Android Studio
```bash
https://developer.android.com/studio
```

Clone this repository and import into **Android Studio**
```bash  
https://github.com/DSC-IIIT-Surat/Curricula
```

## Configuration
### Keystores:
Create `app/keystore.gradle` with the following info:
```gradle
ext.key_alias='...'
ext.key_password='...'
ext.store_password='...'
```
And place both keystores under `app/keystores/` directory:
- `playstore.keystore`
- `stage.keystore`


## Generating signed APK
From Android Studio:
1. ***Build*** menu
2. ***Generate Signed APK...***
3. Fill in the keystore information *(you only need to do this once manually and then let Android Studio remember it)*

## Maintainers
This project is mantained by:
* [Aditya Jaiswal](https://github.com/iam844)
* [Aakash Gavle](https://github.com/aakash-gavle)

