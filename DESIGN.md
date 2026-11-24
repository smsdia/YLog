# YLog Design Tokens

- Source: Figma `YLog 작업 공간`
- Color: 사용자가 전달한 색상 정의 기준 (아래 Color 절 참고)
- Typography: `⭐️typography` section (`234:17663`), Figma text styles 기준
- Typography 값은 `get_variable_defs` 결과가 원본이다. 프레임 안 라벨과 다를 경우 변수 값을 따른다.

---

## 1. Color

토큰 이름은 `Primary/Violet/500`처럼 그룹, 이름, 단계 순서로 쓴다.
이 절의 값은 Figma 변수를 다시 읽어서 확인한 것이 아니라 사용자가 전달한 색상 정의를 옮긴 것이다. Figma와 대조하기 전까지 값의 원본은 이 문서와 `YLogColors.kt`이다.

### Primary / Violet (브랜드)

| Token | Hex |
|---|---|
| Primary/Violet/50 | `#FAF8FC` |
| Primary/Violet/100 | `#F3F0FF` |
| Primary/Violet/200 | `#EBE4FF` |
| Primary/Violet/300 | `#D6C8FF` |
| Primary/Violet/400 | `#A58BFC` |
| Primary/Violet/500 | `#7153F5` |
| Primary/Violet/600 | `#5E3BE6` |
| Primary/Violet/700 | `#53389E` |
| Primary/Violet/800 | `#3B2375` |
| Primary/Violet/900 | `#221834` |

### Primary / Pink (강조)

| Token | Hex |
|---|---|
| Primary/Pink/50 | `#FFF0F5` |
| Primary/Pink/100 | `#FFE0EC` |
| Primary/Pink/200 | `#FFB8D2` |
| Primary/Pink/300 | `#FF80AE` |
| Primary/Pink/400 | `#FF4D90` |
| Primary/Pink/500 | `#FF2D78` |
| Primary/Pink/600 | `#E01863` |
| Primary/Pink/700 | `#B80A4C` |
| Primary/Pink/800 | `#8A0035` |

### Primary / Peach (보조)

| Token | Hex |
|---|---|
| Primary/Peach/50 | `#FFF7F2` |
| Primary/Peach/100 | `#FFEBDD` |
| Primary/Peach/200 | `#FFD4BA` |
| Primary/Peach/300 | `#FFB388` |
| Primary/Peach/400 | `#FA9251` |
| Primary/Peach/500 | `#F77626` |
| Primary/Peach/600 | `#D65C13` |
| Primary/Peach/700 | `#A84206` |
| Primary/Peach/800 | `#7A2D00` |

### Neutral

| Token | Hex |
|---|---|
| Neutral/0 | `#FFFFFF` |
| Neutral/50 | `#FAF8FB` |
| Neutral/100 | `#EDE8F5` |
| Neutral/200 | `#DDD7E7` |
| Neutral/300 | `#CDD0D5` |
| Neutral/400 | `#B1B6BE` |
| Neutral/500 | `#8A949E` |
| Neutral/600 | `#6E6480` |
| Neutral/700 | `#454C53` |
| Neutral/800 | `#31363D` |
| Neutral/900 | `#1E152A` |
| Neutral/950 | `#110C18` |

### System

단계는 50 / 200 / 400 / 600 / 800 다섯 개만 정의되어 있다.

| Token | Success | Warning | Danger | Info |
|---|---|---|---|---|
| 50 | `#EFFCF3` | `#FFF7ED` | `#FFF0F2` | `#F3F0FF` |
| 200 | `#B5F2C4` | `#FFD7A8` | `#FFBDC6` | `#D6C8FF` |
| 400 | `#43D66A` | `#FF9B38` | `#FF697C` | `#A58BFC` |
| 600 | `#1EAC44` | `#E0740E` | `#E6203D` | `#7153F5` |
| 800 | `#126829` | `#8C4300` | `#8A0C1E` | `#3B2375` |

Info는 Primary/Violet의 100, 300, 400, 500, 800과 값이 같다.

### Glass (알파)

| Token | Hex (ARGB) | 불투명도 |
|---|---|---|
| glassWhite80 | `#CCFFFFFF` | 80% 흰색 |
| glassWhite50 | `#80FFFFFF` | 50% 흰색 |
| glassWhite20 | `#33FFFFFF` | 20% 흰색 |
| dimBlack70 | `#B3000000` | 70% 검정 |
| dimBlack40 | `#66000000` | 40% 검정 |
| shadowBlack10 | `#1A000000` | 10% 검정 |

### 확인 필요한 사항

- Neutral/300 ~ 500, 700, 800은 푸른 회색(`#CDD0D5` 등)이고 0 ~ 200, 600, 900, 950은 보라 틴트이다. 의도한 구성인지 디자이너 확인이 필요하다.
- Danger는 원래 브랜드 레드 `#FF3C55`를 기반으로 한다고 알려졌지만, 정의된 단계 값(400은 `#FF697C`, 600은 `#E6203D`)에는 이 값이 없다.

---

## 2. Typography

- Font family: **Pretendard** (전 스타일 공통)
- Letter spacing: 전 스타일 **-2%** (em 기준 -0.02em)
- 단위는 Figma px 기준. Android에서는 sp로 옮기면 된다.

| Style | Size | Weight | Line height | Letter spacing |
|---|---|---|---|---|
| Display/40 | 40 | Bold 700 | 52 | -2% |
| Heading/32 | 32 | Bold 700 | 42 | -2% |
| Heading/28 | 28 | Bold 700 | 38 | -2% |
| Heading/24 | 24 | Bold 700 | 34 | -2% |
| Title/22 | 22 | SemiBold 600 | 30 | -2% |
| Title/20 | 20 | SemiBold 600 | 28 | -2% |
| Title/18 | 18 | SemiBold 600 | 26 | -2% |
| Body/18 | 18 | Regular 400 | 28 | -2% |
| Body/16 | 16 | Regular 400 | 24 | -2% |
| Body/14 | 14 | Regular 400 | 22 | -2% |
| Label/16 | 16 | SemiBold 600 | 22 | -2% |
| Label/14 | 14 | SemiBold 600 | 20 | -2% |
| Caption/12 | 12 | Medium 500 | 18 | -2% |

참고: 디자인 파일 안에 "프루부체 만들어보기 (pretendard 너비 줄인 버전)"이라는 메모가 있다. 지금은 Pretendard 기준이고, 커스텀 폰트는 추후 계획으로 보인다.

---

## 3. 코드 매핑 (`core:designsystem`)

용도 토큰(brand 등)은 두지 않고 Figma 이름을 그대로 쓴다. 화면 코드가 색을 직접 고른다.

| Figma | 코드 |
|---|---|
| Primary/Violet/500 | `YLog.colors.primary.violet500` |
| Neutral/900 | `YLog.colors.neutral.n900` (숫자 시작을 피하려고 `n` 접두어) |
| System/Danger/600 | `YLog.colors.system.danger600` |
| Title/20 | `YLog.typography.title.t20` |
| Body/16 | `YLog.typography.body.b16` |

- 타이포그래피 그룹 접두어: `d`(Display), `h`(Heading), `t`(Title), `b`(Body), `l`(Label), `c`(Caption)
- `MaterialTheme`은 background, surface, onBackground, onSurface만 Neutral로 연결했다. `primary` 계열은 연결하지 않았다.
- 다크 테마는 지원하지 않는다.

---

## 4. 이 문서에 없는 것

- Spacing, radius, elevation 토큰: 확인한 노드(color/typography 섹션)에 없었다.
- Layout foundations 섹션(`236:21123`)에 iOS(393×852), Android(360×800) 템플릿과 Safe Area 구조가 있다. 수치 규칙만 확인했고 별도 토큰화는 하지 않았다.
- 컴포넌트(Tab Bar, App bar 등)의 토큰 바인딩은 읽지 않았다.
