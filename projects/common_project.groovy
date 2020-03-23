repositories {
  mavenCentral()
  google()
  jcenter()
}

apply plugin: 'com.android.application'

android {
  compileSdkVersion 29

  defaultConfig {
    minSdkVersion 19
    targetSdkVersion 29

    versionCode 1
    versionName '1'
  }

  lintOptions {
    checkReleaseBuilds false
  }

  productFlavors {
    flavorDimensions 'type'

    javaOnly {
      dimension 'type'
    }
    javaWithAndroid {
      dimension 'type'
    }
  }

  sourceSets {
    javaWithAndroid {
      java.srcDirs += ['../androidSrc']
    }
  }
}
