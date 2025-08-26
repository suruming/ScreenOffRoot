# ScreenOffRoot (Root-only Quick Settings tile)

Minimal Android app with **no Activity** that adds a **Quick Settings tile**.
When tapped, it requests root and sends key events to **turn the screen off**.

## Build
- Android Studio Ladybug or newer
- Gradle 8.5+, AGP 8.5.2, Kotlin 1.9.24
- `minSdk=24`, `targetSdk=34`

Steps:
1. Install the APK on a **rooted** device.
2. Pull down Quick Settings → Edit → drag the "Screen Off" tile in.
3. First tap will prompt for SU. **Grant** root.
4. Next taps will immediately turn the screen off.

## Notes
- It first tries `KEYCODE_SLEEP (223)` which doesn't toggle the screen.
  If unsupported by your ROM, it falls back to `KEYCODE_POWER (26)`.
- No activities or custom UI are included.