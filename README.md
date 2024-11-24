# SimplePos

**SimplePos** is a lightweight Bukkit/Spigot plugin that allows players to broadcast their current location (coordinates) in the global chat. It includes per-player cooldowns and customizable messages.

---

## Features
- Use the `/pos` command to broadcast your current location to the global chat.
- Configurable cooldown period per player.
- Fully customizable location and notification messages.
- Lightweight and easy to use.

---

## Installation
1. **Download the Plugin**  
   Download the latest `.jar` file from the [Releases](https://github.com/your-repository/releases) page.

2. **Add to Your Server**  
   Place the `.jar` file into your server's `plugins` folder.

3. **Restart Your Server**  
   Restart the server to enable the plugin.

4. **Check Configuration**  
   Upon first launch, the plugin will generate a `config.yml` file. Edit it as needed to suit your preferences.

---

## Commands

| Command        | Description                       | Permission   |
|----------------|-----------------------------------|--------------|
| `/pos`         | Broadcasts your current location | All players  |

---

## Configuration File (`config.yml`)

Below is the default configuration file:

```yaml
cooldown: 60

messages:
  not-a-player: "&cThis command can only be used by players."
  cooldown: "&cYou are on cooldown. Please wait {time} seconds."
  position-message: "&6{player} is at X:{x}, Y:{y}, Z:{z}."
```
## Configuration Options
 - cooldown
Sets the cooldown period for the /pos command (in seconds).

 - messages
Customizable message templates. You can use placeholders like {player}, {x}, {y}, {z}, and {time} for dynamic content.

## Tested Versions
Minecraft 1.16 to 1.21
## Developer Information
This plugin is simple to modify or extend. If you’re interested in development, feel free to clone the repository and make changes.

Clone the repository:

## bash

```git clone https://github.com/your-repository/SimplePos.git```
Build with Maven:

## bash
```mvn clean package```
## License
This project is licensed under the MIT License.

---------------------------------------

# SimplePos

**SimplePos** は、プレイヤーの現在位置（座標）を全体チャットに送信できるシンプルなBukkit/Spigotプラグインです。プレイヤーごとのクールダウン機能を備えており、座標メッセージや通知をカスタマイズすることができます。

---

## 機能
- `/pos` コマンドで現在位置を全体チャットに送信
- プレイヤーごとに設定可能なクールダウン時間
- 座標メッセージや通知メッセージのカスタマイズ
- シンプルで軽量、すぐに利用可能

---

## インストール方法
1. **プラグインをダウンロード**  
   最新の `.jar` ファイルを [Releases](https://github.com/your-repository/releases) からダウンロードします。

2. **サーバーに導入**  
   ダウンロードした `.jar` ファイルをサーバーの `plugins` フォルダに配置します。

3. **サーバーを再起動**  
   サーバーを再起動してプラグインを有効化します。

4. **設定ファイルの確認**  
   サーバーを起動すると、自動的に `config.yml` ファイルが生成されます。必要に応じて設定を編集してください。

---

## コマンド

| コマンド        | 説明                          | 権限       |
|-----------------|-------------------------------|------------|
| `/pos`          | 現在位置を全体チャットに送信 | すべてのプレイヤー |

---

## 設定ファイル (`config.yml`)

以下は、デフォルトの `config.yml` の内容です。

```yaml
cooldown: 60

messages:
  not-a-player: "&cこのコマンドはプレイヤー専用です。"
  cooldown: "&cクールダウン中です。あと {time} 秒お待ちください。"
  position-message: "&6{player} は X:{x}, Y:{y}, Z:{z} にいます。"
```

## 設定項目
 - cooldown

プレイヤーごとのクールダウン時間（秒単位）。

 - messages

メッセージテンプレート。{player} や {x}, {y}, {z}, {time} を使って動的に変更できます。

## 動作確認済みバージョン
Minecraft 1.16 ～ 1.21
## 開発者向け情報
このプラグインは簡単にカスタマイズや拡張が可能です。開発に関心がある場合は、リポジトリをクローンしてコードを自由に編集してください。

リポジトリをクローン：

### bash
コードをコピーする
```git clone https://github.com/your-repository/SimplePos.git```
Maven を使用してビルド：

### bash
コードをコピーする
```mvn clean package```
ライセンス
このプロジェクトは MIT License のもとで公開されています。
