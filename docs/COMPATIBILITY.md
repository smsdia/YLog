# Compatibility

Single source for minimum supported versions. Read it before changing `minSdk`, `targetSdk`, or the iOS deployment target.

| Platform | Value | Reason |
| --- | --- | --- |
| Android `minSdk` | 24 | ARCore and ML Kit Subject Segmentation both require API 24 |
| Android `compileSdk` / `targetSdk` | 37 | Kept in `gradle/libs.versions.toml` |
| iOS deployment target | 17.0 | Vision `VNGenerateForegroundInstanceMaskRequest` requires iOS 17. Set in `app/iosApp/iosApp.xcodeproj` (`IPHONEOS_DEPLOYMENT_TARGET`) |

## AR support

- Android: only ARCore-supported devices can use the camera tab. Other devices show a guidance screen; library, decoration, and log stay usable.
- iOS: ARKit plane detection needs a physical iPhone. The simulator does not support AR.
