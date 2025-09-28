# InkWell

A simple, elegant, offline-first note-taking app for Android, designed to mirror the iOS Notes experience while offering a minimal OLED-black UI.

## Features

- **Offline-first design** - No cloud dependencies, works completely offline
- **OLED black UI** - True black (#000000) background optimized for OLED displays
- **Rich text editing** - Headings, lists, checklists, and formatting
- **Folder organization** - Organize notes with folders and manual tags
- **Powerful search** - SQLite FTS (Full Text Search) for fast note discovery
- **Biometric security** - Lock sensitive notes with fingerprint/face unlock
- **Home screen widgets** - Quick Note and Pinned Notes widgets
- **Share integration** - Share content to InkWell from other apps

## Tech Stack

- **Kotlin** + **Jetpack Compose** for modern UI
- **Room** (SQLite) database with FTS
- **Hilt** dependency injection
- **Material 3** design system
- **DataStore** for preferences
- **Keystore** + **BiometricPrompt** for encryption
- **Glance** for home screen widgets

## Project Structure

```
app/
├── src/main/java/com/inkwell/app/
│   ├── data/
│   │   ├── local/
│   │   │   ├── entity/          # Room database entities
│   │   │   ├── dao/             # Data access objects
│   │   │   ├── database/        # Database configuration
│   │   │   └── converter/       # Type converters
│   │   └── repository/          # Repository pattern implementation
│   ├── domain/
│   │   ├── model/               # Domain models
│   │   └── usecase/             # Business logic use cases
│   ├── ui/
│   │   ├── screen/              # Compose screens
│   │   ├── navigation/          # Navigation setup
│   │   └── theme/               # Material 3 theme
│   ├── di/                      # Hilt dependency injection
│   └── widget/                  # Home screen widgets
└── src/main/res/
    ├── values/                  # Strings, colors, themes
    └── xml/                     # Widget configurations
```

## Getting Started

### Prerequisites

- **Android Studio** Hedgehog (2023.1.1) or later
- **Android SDK** API 24+ (Android 7.0)
- **Kotlin** 1.9.20+
- **Gradle** 8.4+

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd InkWell
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the InkWell folder and open it

3. **Sync Project**
   - Android Studio will automatically sync Gradle files
   - Wait for the sync to complete

4. **Build and Run**
   - Connect an Android device or start an emulator
   - Click the "Run" button or press `Shift + F10`
   - The app will install and launch on your device

### Development Setup

1. **Enable Developer Options** on your Android device
2. **Enable USB Debugging**
3. **Connect device** via USB or use Android Emulator
4. **Run the app** - it will automatically install and launch

## Architecture

The app follows **Clean Architecture** principles with clear separation of concerns:

- **UI Layer**: Jetpack Compose screens and navigation
- **Presentation Layer**: ViewModels and state management
- **Domain Layer**: Use cases and business logic
- **Data Layer**: Repository pattern with Room database
- **Platform Layer**: Android-specific implementations

## Security Features

- **AES-GCM encryption** for note content
- **Android Keystore** for secure key storage
- **BiometricPrompt** for user authentication
- **Local storage only** - no cloud sync

## Testing

The project includes comprehensive testing setup:

- **Unit Tests**: JUnit for business logic
- **UI Tests**: Compose UI testing framework
- **Integration Tests**: Room database testing

Run tests:
```bash
./gradlew test
./gradlew connectedAndroidTest
```

## Building for Release

1. **Generate signed APK**:
   ```bash
   ./gradlew assembleRelease
   ```

2. **Generate AAB for Play Store**:
   ```bash
   ./gradlew bundleRelease
   ```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## License

MIT License - see LICENSE file for details

## Roadmap

- **V1.0**: Core note-taking with OLED UI
- **V1.1**: Note linking and version history
- **V1.2**: Document scanner with OCR
- **V2.0**: End-to-end encrypted cloud sync
- **Pro**: Collaboration features and advanced filters