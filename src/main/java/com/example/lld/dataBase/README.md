# MiniDB — In-Memory Database (Java LLD)

This project is a **low-level design (LLD)** implementation of an in-memory database system in Java. It demonstrates *
*SOLID OOP principles** and applies multiple **design patterns** (Singleton, Factory, Builder, Repository, Strategy,
Command, Facade). This can be used as a reference for interviews and system design practice.

---

## ✨ Features

- Manage **Databases** (create, delete).
- Manage **Tables** (create, delete, modify schema).
- Manage **Indexes** (create, delete, rebuild).
- Supported **Data Types**:
    - `STRING` (max length = 20)
    - `INT` (range = [-1024, 1024])
- Support for **constraints**:
    - Required (non-nullable) columns.
- Operations:
    - `INSERT`
    - `SELECT` (with equality filter + index support)
    - `UPDATE`
    - `DELETE`
    - `TRUNCATE`
- **Schema changes**: add/drop columns.
- **Print all rows** in a table.
- **Indexes** accelerate equality lookups.

---

## 📂 Project Structure

```
com.mini.db/
├─ App.java                 # Demo runner
├─ manager/DBManager.java   # Singleton DB manager
├─ model/                   # Data model classes
│  ├─ Column.java
│  ├─ DataType.java
│  └─ TableSchema.java
├─ repository/              # Storage layer
│  ├─ TableRepository.java
│  └─ InMemoryTableRepository.java
├─ index/                   # Indexes
│  ├─ Index.java
│  ├─ IndexStrategy.java
│  └─ strategy/HashIndexStrategy.java
├─ command/                 # DML commands (Command pattern)
│  ├─ Command.java
│  ├─ InsertCommand.java
│  ├─ UpdateCommand.java
│  └─ DeleteCommand.java
├─ factory/EntityFactory.java   # Factory for schema/columns
└─ exception/                  # Custom exceptions
   ├─ DBException.java
   ├─ SchemaException.java
   └─ IndexException.java
```

---

## 🏗️ Design Patterns Used

- **Singleton** → `DBManager`
- **Factory** → `EntityFactory`
- **Builder** → `Column.Builder`, `TableSchema.Builder`
- **Repository** → `TableRepository`, `InMemoryTableRepository`
- **Strategy** → `IndexStrategy` (`HashIndexStrategy`)
- **Command** → `InsertCommand`, `UpdateCommand`, `DeleteCommand`
- **Facade (optional)** → Simple entrypoint for demo/CLI

---

## 🚀 Example Usage

```java
//DBManager mgr = DBManager.getInstance();
//
//// Create DB & Table
//mgr.createDatabase("crm");
//Column id = EntityFactory.column("id", DataType.INT, true);
//Column name = EntityFactory.column("name", DataType.STRING, true);
//Column city = EntityFactory.column("city", DataType.STRING, false);
//var schema = EntityFactory.schema(id, name, city);
//mgr.createTable("crm", "customers", schema);
//
//TableRepository repo = mgr.table("crm", "customers");
//repo.addIndex("idx_name", "name");
//
//// Insert
//new InsertCommand(repo, Map.of("id", 1, "name", "Alice", "city", "Pune")).execute();
//new InsertCommand(repo, Map.of("id", 2, "name", "Bob", "city", "Mumbai")).execute();
//
//// Print
//repo.printAll();
//
//// Select
//System.out.println(repo.select(Map.of("name", "Bob")));
//
//// Update
//new UpdateCommand(repo, Map.of("name", "Alice"), Map.of("city", "Delhi")).execute();
//repo.printAll();
//
//// Delete
//new DeleteCommand(repo, Map.of("name", "Bob")).execute();
//repo.printAll();
```

---

## ⚡ Key Concepts

- **Rows stored** as `LinkedHashMap<String, Object>` → preserves column order.
- **Indexes** stored as `Map<Object, LinkedHashSet<Integer>>` → O(1) expected equality lookup.
- **varFiltersCg** variable → used in filter matching (per problem statement).
- **Validation** centralized in `Column.validateValue()`.
- **Schema changes** update rows & indexes accordingly.

---

## 📊 Complexity

- **Insert**: O(C + I) → columns + indexes.
- **Select**:
    - Indexed equality: O(1 + k) (k = matches).
    - Otherwise: O(N*F) (rows × filters).
- **Update/Delete**: find cost + index updates.
- **Truncate**: O(N + I).

---

## 🛠️ Limitations

- No persistence (in-memory only).
- Only single-column indexes.
- Only equality-based filter optimization.
- No transactions/ACID.
- Not thread-safe.

---

## 🔮 Possible Improvements

- Add **Tree-based index** (range queries).
- Support **composite indexes**.
- Add **transactions** and rollback.
- Add **persistence layer** (disk-backed).
- Add **SQL-like parser** / REPL CLI.
- Make repository **thread-safe** (`ReentrantReadWriteLock`).

---

## 📚 Interview Talking Points

- Why **LinkedHashMap** vs HashMap?
- How to support **composite indexes**?
- How to add **range queries**?
- How to ensure **thread-safety**?
- How to handle **schema migrations**?
- How to scale to **disk/persistence**?

---

## ✅ Summary

This project demonstrates a **mini relational database system** built using core Java, applying **design patterns** and
**OOP principles**. It’s useful for practicing **LLD machine coding**, **system design interviews**, and **revision
before interviews**.
