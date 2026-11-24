# Lab Task 09: Creational Design Patterns — The Singleton Pattern

**Subject:** Software Construction (5th Semester Software Engineering)  
**Institution:** University of Engineering & Technology, Abbottabad Campus  
**Repository:** [https://github.com/ayeshaMalik2026/Lab09-Singleton-Pattern](https://github.com/ayeshaMalik2026/Lab09-Singleton-Pattern)

---

## Objective
Apply creational software construction principles by designing centralized, memory-safe, and thread-safe Singleton components in Java that prevent duplicate resource allocation and maintain consistent shared state across modules.

---

## Lab Tasks Overview

### 1. Lab Task 1 — Centralized Database Connection Manager (Lazy Singleton)
* **Goal:** Prevent resource exhaustion caused by multiple modules opening redundant database connections.
* **Implementation:** `DatabaseConnectionManager` uses a private constructor, a static instance counter tracking constructor invocations, and `executeQuery(String moduleName, String sql)`.
* **Verification (`Task1Main`):** Simulates `StudentPortal`, `FeeBillingService`, and `AttendanceTracker` requesting instances, prints `System.identityHashCode()` for each reference, executes sample SQL queries, and proves single-instance creation via `==` reference equality.

### 2. Lab Task 2 — Campus Print Spooler Queue (Shared State Consistency)
* **Goal:** Maintain a single synchronized job queue across multiple computer laboratories.
* **Implementation:** `PrintSpooler` encapsulates a FIFO `Queue<String>` (`LinkedList<String>`) with `addPrintJob(String labName, String documentName)`, `processNextJob()`, and `getPendingJobCount()`.
* **Verification (`Task2Main`):** Client classes `SoftwareLab1` (two jobs) and `NetworkingLab2` (one job) submit jobs to the shared spooler, which processes all jobs sequentially in FIFO order without losing or overwriting entries.

### 3. Lab Task 3 — Exposing & Fixing Race Conditions in Naive Singletons (Thread Safety)
* **Goal:** Demonstrate why a basic Lazy Singleton fails under multithreading and refactor it using Double-Checked Locking.
* **Implementation:** `AuditLogger` / `AuditLogger1` simulates initialization latency using `Thread.sleep(50)` across 5 concurrent worker threads. First runs without synchronization to expose multiple instance hash codes, then enforces thread safety using `volatile` and Double-Checked Locking (`synchronized`).

---

## How to Run the Code

### Option 1: Using Apache NetBeans
1. Clone or download this repository:
   ```bash
   git clone [https://github.com/ayeshaMalik2026/Lab09-Singleton-Pattern.git](https://github.com/ayeshaMalik2026/Lab09-Singleton-Pattern.git)
