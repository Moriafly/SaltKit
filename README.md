# SaltKit

Android 开发工具包，自然排序、图片操作等，正在持续开发中

## 使用

### 1. 项目 Gradle 添加 JitPack 依赖

```groovy
allprojects {
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }
}
```

### 2. 要使用的模块下添加 SaltKit 依赖

最新版本⬇️⬇️⬇️

[![](https://jitpack.io/v/Moriafly/SaltKit.svg)](https://jitpack.io/#Moriafly/SaltKit)

```groovy
dependencies {
    // ...
    // 将 <VERSION> 替换为具体的版本号，如 0.1.0-dev07 
    // 即 implementation 'com.github.Moriafly:SaltKit:0.1.0-dev07'
    // 推荐使用上方最新版本或稳定版本（若有）
    implementation 'com.github.Moriafly:SaltUI:<VERSION>'
}
```

## SortKit 排序

| 功能   | 介绍                                               | API             |
|------|--------------------------------------------------|-----------------|
| 自然排序 | 自然排序，如 2、1、12 排序后为 1、2、12 而非 1、12、2，可自定义非数字部分的排序 | sortedByNatural |

## BitmapKit 图片处理

| 功能    | 介绍               | API                   |
|-------|------------------|-----------------------|
| 生成纯色  | 生成指定大小纯色 Bitmap  | createBitmapFullColor |
| 中心裁切  | 实现 CenterCrop 功能 | centerCrop            |
| 裁为正方形 | 裁为正方形            | square                |

## ColorKit

| 功能 | 介绍     | API |
|----|--------|-----|
| 混合 | 混合多个颜色 | mix |

## ThreadKit

| 功能     | 介绍     | API             |
|--------|--------|-----------------|
| 切换至主线程 | 切换至主线程 | runOnMainThread |

## 贡献

[贡献者行为准则](CODE_OF_CONDUCT.md)

## 版权

LGPL-2.1 License，详见 [LICENSE](LICENSE)

使用开源库：AndroidX、Kotlin、Glide 等

更多请参考代码文件注释说明

```
SaltKit
Copyright (C) 2023 Moriafly

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.
```

## 星星历史

[![Star History Chart](https://api.star-history.com/svg?repos=Moriafly/SaltKit&type=Date)](https://star-history.com/#Moriafly/SaltKit&Date)