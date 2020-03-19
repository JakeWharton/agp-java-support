repositories {
  mavenCentral()
  google()
  jcenter()
}

def agpVersion
if (System.getProperty('agpVersion') != null) {
  agpVersion = System.getProperty('agpVersion')
  println("Using AGP $agpVersion")
} else {
  println("Defaulting to latest AGP")
  agpVersion = '+'
}

dependencies {
  classpath "com.android.tools.build:gradle:$agpVersion"
}
