# Product Requirements Document (PRD)

**Product Name:** InkWell (working title)  
**Version:** V1 (Offline-first)  
**Prepared by:** Product Manager (📋 Sarah)  
**Date:** 2025-09-28  

---

## 1. Product Overview
A simple, elegant, offline-first note-taking app for Android, designed to mirror the iOS Notes experience while offering a minimal OLED-black UI. Free to download, prioritizing speed, privacy, and simplicity.  

## 2. Goals & Non-Goals
**Goals**
- Offline, iOS Notes–like experience
- OLED black UI
- Local storage with biometric lock
- Ship quickly via MVP → V1  

**Non-Goals**
- Cloud sync
- OCR / document scan
- Finger drawing / sketch
- Activity history

## 3. Target Users
- Everyday note-takers
- Privacy-conscious users
- OLED device owners

## 4. Key Features (V1 Scope)
- Rich text editor (headings, lists, checklists, formatting)
- Folders + manual tags
- Search via SQLite FTS
- Attach images/files
- Lock notes (biometric/passcode)
- Widgets (Quick Note, Pinned Notes)
- Share sheet target
- OLED true black UI

## 5. Technical Requirements
- Kotlin + Jetpack Compose (Material 3, Glance)
- Room (SQLite) + FTS
- DataStore for preferences
- Hilt for DI
- Keystore + BiometricPrompt for encryption
- Testing: JUnit, Espresso/Compose UI
- IDE: Android Studio + Cursor AI (Claude Sonnet integration)

## 6. UX & Design
- True black background (#000000)
- Material 3 dynamic accents
- Accessible typography + contrast

## 7. Risks
- Rich text editor complexity → scope to Markdown-lite
- Search performance → FTS
- Encryption UX → Biometric integration
- Play Store compliance → privacy policy

## 8. Release Strategy
- Alpha → core notes
- Beta → encryption, widgets
- V1 launch → full scope

## 9. Success Metrics
- 30-day retention >25%
- Rating >4.5
- Downloads >10k in 6 months
- Crash-free sessions >98%

## 10. Future Roadmap
- V1.1: note linking, version history
- V1.2: scanner + OCR
- V2.0: E2EE cloud sync
- Pro: collaboration, advanced filters
