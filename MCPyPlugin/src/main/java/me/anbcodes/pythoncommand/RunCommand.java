package me.anbcodes.pythoncommand;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import py4j.GatewayServer;

public class RunCommand extends JavaPlugin {
	public static void main(String[] args) {}
	public class Sender implements ConsoleCommandSender {
		public String[] messages;
		public ConsoleCommandSender CSender = Bukkit.getServer().getConsoleSender();
		@Override
		public String getName() {
			return "MCPyPlugins";
		}

		@Override
		public Server getServer() {
			return CSender.getServer();
		}

		@Override
		public void sendMessage(String arg0) {
			System.out.println("send");
			this.messages = new String[1];
			this.messages[0] = arg0;
		}

		@Override
		public void sendMessage(String[] arg0) {
			System.out.println("send2");
			this.messages = arg0;
			
		}

		@Override
		public Spigot spigot() {
			return CSender.spigot();
		}

		@Override
		public PermissionAttachment addAttachment(Plugin arg0) {
			return CSender.addAttachment(arg0);
		}

		@Override
		public PermissionAttachment addAttachment(Plugin arg0, int arg1) {
			return CSender.addAttachment(arg0, arg1);
		}

		@Override
		public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2) {
			return CSender.addAttachment(arg0, arg1, arg2);
		}

		@Override
		public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2, int arg3) {
			return CSender.addAttachment(arg0, arg1, arg2, arg3);
		}

		@Override
		public Set<PermissionAttachmentInfo> getEffectivePermissions() {
			return CSender.getEffectivePermissions();
		}

		@Override
		public boolean hasPermission(String arg0) {
			return CSender.hasPermission(arg0);
		}

		@Override
		public boolean hasPermission(Permission arg0) {
			return CSender.hasPermission(arg0);

		}

		@Override
		public boolean isPermissionSet(String arg0) {
			return CSender.isPermissionSet(arg0);
		}

		@Override
		public boolean isPermissionSet(Permission arg0) {
			return CSender.isPermissionSet(arg0);
		}

		@Override
		public void recalculatePermissions() {
			recalculatePermissions();			
		}

		@Override
		public void removeAttachment(PermissionAttachment arg0) {
			removeAttachment(arg0);			
		}

		@Override
		public boolean isOp() {
			return CSender.isOp();
		}

		@Override
		public void setOp(boolean arg0) {
			CSender.setOp(arg0);		
		}
		@Override
		public boolean isConversing() {
			return CSender.isConversing();
		}
		public void abandonConversation(Conversation a0, ConversationAbandonedEvent a1) {
			CSender.abandonConversation(a0 ,a1);
		}
		public void abandonConversation(Conversation a0) {
			CSender.abandonConversation(a0);
		}
		public void acceptConversationInput(String a0) {
			CSender.acceptConversationInput(a0);
		}
		public boolean beginConversation(Conversation a0) {
			return CSender.beginConversation(a0);
			
		}
		public void sendRawMessage(String a0) {
			CSender.sendRawMessage(a0);
		}
		
	}
	public String[] run(String command) {
		Sender sender = new Sender();
		int re = 0;
		try {
			Bukkit.getScheduler().callSyncMethod(this, () -> Bukkit.dispatchCommand( sender , command ));
			// System.out.println(sender.messages);
			return sender.messages;
		} catch (Exception e) {
			re = 1;
			throw(e);
			
		}
		// Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), command);
	}
//	hello
	GatewayServer GServer = null;
	@Override
	public void onEnable() {
		RunCommand app = this;
		GServer = new GatewayServer(app);
		GServer.start();
		
	}
	
	@Override
	public void onDisable() {
		GServer.shutdown();
	}
}
