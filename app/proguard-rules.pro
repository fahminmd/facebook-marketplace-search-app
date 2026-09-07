-keepattributes Signature
-keepattributes *Annotation*
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *; }
-keep interface com.squareup.okhttp3.** { *; }
-dontwarn okio.**
-keep class okio.** { *; }
-dontwarn retrofit2.Platform$Java8
-keepattributes RuntimeVisibleAnnotations
-keepattributes RuntimeVisibleParameterAnnotations
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-keep @interface retrofit2.http.*
-keepclasseswithmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}
