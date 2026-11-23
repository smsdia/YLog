# Data layer

`data:<feature>` implements the Repository interfaces declared in `domain:<feature>`. It is created with the first feature that needs it.

## Contents

| Item | Rule |
| --- | --- |
| Repository implementation | `internal`. Binds to its domain interface with `@ContributesBinding(AppScope::class)` |
| Entity / DTO | `internal` (Room `@Entity`, `@Serializable`). Never leaves the module |
| Mapper | Converts entity or DTO to the domain model. Covered by tests |
| Storage access | Uses `core:database` for structured records and `core:datastore` for general values |

## Dependencies

- Allowed: its own `domain:<feature>`, `core:model`, `core:database`, `core:datastore`, `core:common`.
- Never depended on by `presentation:*`. `app:shared` depends on it directly so Metro can collect its bindings.
- Room types do not cross the module boundary.

## Failures

- Wrap suspend work with `suspendRunCatching`, never plain `runCatching` (see [error-handling](error-handling.md)).
- Convert storage and file failures to `YLogException` in this layer.

## Tests

Required: error mapping and entity-to-model mapping. Do not write tests that only check delegation or library behavior. See [HARNESS](../HARNESS.md#required-tests-by-layer).
