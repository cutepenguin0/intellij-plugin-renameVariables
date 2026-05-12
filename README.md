# IntelliJ Plugin – Rename Variables Assistant

This IntelliJ IDEA plugin helps developers quickly rename local variables using suggestions based on variable type or name patterns.
It provides a dialog that analyzes selected variables and offers naming suggestions to improve code readability.

---
##  How does renaming work?

The plugin currently supports two strategies:

### 1. Type-based suggestions
Generates variable name suggestions based on the variable's type.

Example:
- `String` → `name`, `label`, `text`, `description`
- `int` → `count`, `value`, `index`

### 2. Name-based suggestions
Suggests expanded names based on the current variable name.

---

## Tech Stack

- Java
- IntelliJ Platform SDK
- Gradle (IntelliJ Plugin Plugin)
- Swing UI 

---
## Build & Run

### Prerequisites
- IntelliJ IDEA
- JDK 17+

### Build plugin:
```bash
./gradlew buildPlugin
```

### Run in development
```bash
./gradlew runIde
```

---
## **Author's note**

This is a simple project with many opportunities for extension:

- Adding feature where user can add their own name suggestions which they often use themselves.
- Integrate AI assistance:
  - Send local variables and method context to an AI model
  - Receive smarter, context-aware naming suggestions
- Support renaming of methods and class-level variables
- Add project-specific naming conventions

So, this is just a beginning :)
