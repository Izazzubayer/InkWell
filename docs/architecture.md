# System Architecture Document

**Product:** InkWell (working title)  
**Version:** V1 (Offline-first)  
**Prepared by:** System Architect (🏗️ Alex)  
**Date:** 2025-09-28  

---

## 1. Architectural Goals
- Offline-first, no cloud dependencies
- Security-first (encryption, biometric unlock)
- Maintainable, testable layers
- OLED-optimized performance

## 2. High-Level Architecture
UI (Compose, M3)  
→ Presentation (ViewModels, Nav)  
→ Domain (Use Cases)  
→ Data (Repos, Room DB)  
→ Platform (Keystore, MediaStore, Biometric)

## 3. Modules
- **UI Layer:** notes list, editor, folders, settings, widgets
- **Presentation:** ViewModels per feature
- **Domain:** use cases (CRUD, Search, Lock, Export)
- **Data:** Room entities/DAOs, repositories
- **Platform:** Keystore, BiometricPrompt, MediaStore, File I/O

## 4. Data Model
- **NoteEntity:** id, title, content (encrypted), createdAt, updatedAt, pinned, locked, folderId
- **FolderEntity:** id, name, parentId
- **AttachmentEntity:** id, noteId, type, uri, addedAt

## 5. Security
- AES-GCM encryption of note content
- Master key in Keystore
- BiometricPrompt for unlock
- Export: encrypted .zip

## 6. Navigation
Splash → Notes List → [Editor | Folder | Search | Settings | Locked Note]

## 7. Non-Functional Requirements
- Open notes list <200ms
- Search <300ms for 1k notes
- OLED-friendly (true black, low burn-in risk)
- Crash-free sessions ≥98%

## 8. Future-Proofing
- Sync layer can be added later (Firestore/Supabase)
- Optional modules: OCR, scanner, collab, CRDTs
- Graph view for note linking
