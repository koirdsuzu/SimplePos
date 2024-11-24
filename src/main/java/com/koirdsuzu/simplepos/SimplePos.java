package com.koirdsuzu.simplepos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SimplePos extends JavaPlugin implements TabExecutor {

    private Map<UUID, Long> cooldowns = new HashMap<>();
    private int cooldownTime;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfiguration();
        getCommand("pos").setExecutor(this);
        getCommand("pos").setTabCompleter(this);
    }

    private void reloadConfiguration() {
        FileConfiguration config = getConfig();
        cooldownTime = config.getInt("cooldown", 60);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(formatMessage("not-a-player", null));
            return true;
        }

        Player player = (Player) sender;
        UUID playerId = player.getUniqueId();
        long currentTime = System.currentTimeMillis();

        // クールダウンチェック
        if (cooldowns.containsKey(playerId)) {
            long lastUsed = cooldowns.get(playerId);
            long remainingTime = (cooldownTime * 1000) - (currentTime - lastUsed);
            if (remainingTime > 0) {
                player.sendMessage(formatMessage("cooldown", Map.of("time", String.valueOf(remainingTime / 1000))));
                return true;
            }
        }

        // プレイヤー座標のメッセージ
        Location loc = player.getLocation();
        Map<String, String> placeholders = Map.of(
                "player", player.getName(),
                "x", String.valueOf(loc.getBlockX()),
                "y", String.valueOf(loc.getBlockY()),
                "z", String.valueOf(loc.getBlockZ())
        );
        String message = formatMessage("position-message", placeholders);
        Bukkit.broadcastMessage(ChatColor.GOLD + message);

        cooldowns.put(playerId, currentTime);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null; // タブ補完なし
    }

    @Override
    public void onDisable() {
        cooldowns.clear();
    }

    @Override
    public void reloadConfig() {
        super.reloadConfig();
        reloadConfiguration();
    }

    /**
     * メッセージをフォーマットして返します。
     *
     * @param key           設定ファイル内のキー
     * @param placeholders  プレースホルダーと値のマップ
     * @return フォーマットされたメッセージ
     */
    private String formatMessage(String key, Map<String, String> placeholders) {
        String message = getConfig().getString("messages." + key, "メッセージが設定されていません: " + key);
        if (placeholders != null) {
            for (Map.Entry<String, String> entry : placeholders.entrySet()) {
                message = message.replace("{" + entry.getKey() + "}", entry.getValue());
            }
        }
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
