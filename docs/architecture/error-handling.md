# Error handling

## Return type

Repositories return `kotlin.Result<T>`. There is no custom `Result` type.

## Exception types

`domain` defines a sealed `YLogException`. Add a subtype only when a screen reacts to it differently.

| Subtype | Meaning |
| --- | --- |
| `Unknown` | Anything else |

There is no server. Add a subtype (for example a missing file or an unsupported device) when the first feature needs one.

## Flow of a failure

1. `data:*` catches storage and file failures and maps them to `YLogException`. Room types stay inside `data`.
2. The Repository returns `Result.failure(YLogException)`.
3. The ViewModel branches with `when` and turns the failure into `UiState` (an inline error state) or a side effect (toast, dialog). App-wide dialog policy reuses `DialogType` from `core:trigger`.
4. The UI turns the error type into text with a `StringResource`.

## Coroutines

- In `suspend` code use `suspendRunCatching` from `core:common`, not `runCatching`. Plain `runCatching` swallows `CancellationException`.
- `suspendRunCatching` rethrows `CancellationException`, but treats `TimeoutCancellationException` as a failure.

| Don't | Do |
| --- | --- |
| `runCatching { dao.load() }` in a `suspend` function | `suspendRunCatching { dao.load() }` |
