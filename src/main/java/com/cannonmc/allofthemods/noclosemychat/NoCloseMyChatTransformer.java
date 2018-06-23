package com.cannonmc.allofthemods.noclosemychat;

import net.minecraft.launchwrapper.*;
import net.minecraftforge.fml.relauncher.*;
import org.apache.logging.log4j.*;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.*;
import java.util.*;

@SideOnly(Side.CLIENT)
public class NoCloseMyChatTransformer implements IClassTransformer
{
    private static final ObfuscatedNames[] OBFUSCATED_NAMES;
    
    public byte[] transform(final String name, final String transformedName, final byte[] classBytes) {
        if (transformedName.equals("net.minecraft.network.play.server.S2EPacketCloseWindow") || transformedName.equals("net.minecraft.network.play.server.SPacketCloseWindow")) {
            LogManager.getLogger().info("Transforming:  " + transformedName);
            return this.patchClass(transformedName, classBytes);
        }
        return classBytes;
    }
    
    private byte[] patchClass(final String className, final byte[] inputClassBytes) {
        final ClassNode classNode = new ClassNode();
        final ClassReader classReader = new ClassReader(inputClassBytes);
        classReader.accept((ClassVisitor)classNode, 4);
        for (final MethodNode m : classNode.methods) {
            final ObfuscatedNames obf = Arrays.stream(NoCloseMyChatTransformer.OBFUSCATED_NAMES).filter(o -> m.name.equals(o.getProcessPacketMethodName())).filter(o -> m.desc.equals("(L" + o.getINetHandlerClassName() + ";)V")).findFirst().orElse(null);
            if (obf == null) {
                continue;
            }
            final Iterator<AbstractInsnNode> iter = (Iterator<AbstractInsnNode>)m.instructions.iterator();
            final InsnList toInject = new InsnList();
            final LabelNode label = new LabelNode();
            toInject.add((AbstractInsnNode)new MethodInsnNode(184, obf.getMinecraftClassName(), obf.getGetMinecraftMethodName(), "()L" + obf.getMinecraftClassName() + ";", false));
            toInject.add((AbstractInsnNode)new FieldInsnNode(180, obf.getMinecraftClassName(), obf.getCurrentScreenFieldName(), "L" + obf.getGuiScreenClassName() + ";"));
            toInject.add((AbstractInsnNode)new TypeInsnNode(193, obf.getGuiChatClassName()));
            toInject.add((AbstractInsnNode)new JumpInsnNode(153, label));
            toInject.add((AbstractInsnNode)new InsnNode(177));
            toInject.add((AbstractInsnNode)label);
            while (iter.hasNext()) {
                final AbstractInsnNode currentNode = iter.next();
                if (currentNode.getOpcode() == 16 && ((IntInsnNode)currentNode).operand == 100) {
                    toInject.add((AbstractInsnNode)new IntInsnNode(17, 256));
                }
                else {
                    toInject.add(currentNode);
                }
            }
            m.instructions.clear();
            m.instructions.add(toInject);
            System.out.println("Patching S2EPacketCloseWindow... - " + className + "." + m.name + m.desc);
        }
        final ClassWriter writer = new ClassWriter(3);
        classNode.accept((ClassVisitor)writer);
        return writer.toByteArray();
    }
    
    static {
        final String s = "1.8.9";
        switch (s) {
            case "1.7.10": {
                OBFUSCATED_NAMES = new ObfuscatedNames[] { new ObfuscatedNames("processPacket", "net/minecraft/network/INetHandler", "net/minecraft/client/Minecraft", "getMinecraft", "currentScreen", "net/minecraft/client/gui/GuiScreen", "net/minecraft/client/gui/GuiChat"), new ObfuscatedNames("func_148833_a", "net/minecraft/network/INetHandler", "net/minecraft/client/Minecraft", "func_71410_x", "field_71462_r", "net/minecraft/client/gui/GuiScreen", "net/minecraft/client/gui/GuiChat"), new ObfuscatedNames("a", "fb", "bao", "z", "m", "net/minecraft/client/gui/GuiScreen", "bvx") };
                break;
            }
            case "1.8": {
                OBFUSCATED_NAMES = new ObfuscatedNames[] { new ObfuscatedNames("processPacket", "net/minecraft/network/INetHandler", "net/minecraft/client/Minecraft", "getMinecraft", "currentScreen", "net/minecraft/client/gui/GuiScreen", "net/minecraft/client/gui/GuiChat"), new ObfuscatedNames("func_148833_a", "net/minecraft/network/INetHandler", "net/minecraft/client/Minecraft", "func_71410_x", "field_71462_r", "net/minecraft/client/gui/GuiScreen", "net/minecraft/client/gui/GuiChat"), new ObfuscatedNames("a", "hg", "bsu", "z", "m", "bxf", "bvx") };
                break;
            }
            case "1.8.8":
            case "1.8.9": {
                OBFUSCATED_NAMES = new ObfuscatedNames[] { new ObfuscatedNames("processPacket", "net/minecraft/network/INetHandler", "net/minecraft/client/Minecraft", "getMinecraft", "currentScreen", "net/minecraft/client/gui/GuiScreen", "net/minecraft/client/gui/GuiChat"), new ObfuscatedNames("func_148833_a", "net/minecraft/network/INetHandler", "net/minecraft/client/Minecraft", "func_71410_x", "field_71462_r", "net/minecraft/client/gui/GuiScreen", "net/minecraft/client/gui/GuiChat"), new ObfuscatedNames("a", "ep", "ave", "A", "m", "axu", "awv") };
                break;
            }
            case "1.9": {
                OBFUSCATED_NAMES = new ObfuscatedNames[] { new ObfuscatedNames("processPacket", "net/minecraft/network/INetHandler", "net/minecraft/client/Minecraft", "getMinecraft", "currentScreen", "net/minecraft/client/gui/GuiScreen", "net/minecraft/client/gui/GuiChat"), new ObfuscatedNames("func_148833_a", "net/minecraft/network/INetHandler", "net/minecraft/client/Minecraft", "func_71410_x", "field_71462_r", "net/minecraft/client/gui/GuiScreen", "net/minecraft/client/gui/GuiChat"), new ObfuscatedNames("a", "ep", "bcf", "z", "m", "bfb", "bee") };
                break;
            }
            case "1.9.4": {
                OBFUSCATED_NAMES = new ObfuscatedNames[] { new ObfuscatedNames("processPacket", "net/minecraft/network/INetHandler", "net/minecraft/client/Minecraft", "getMinecraft", "currentScreen", "net/minecraft/client/gui/GuiScreen", "net/minecraft/client/gui/GuiChat"), new ObfuscatedNames("func_148833_a", "net/minecraft/network/INetHandler", "net/minecraft/client/Minecraft", "func_71410_x", "field_71462_r", "net/minecraft/client/gui/GuiScreen", "net/minecraft/client/gui/GuiChat"), new ObfuscatedNames("a", "er", "bcd", "z", "m", "bez", "bec") };
                break;
            }
            case "1.10.2": {
                OBFUSCATED_NAMES = new ObfuscatedNames[] { new ObfuscatedNames("processPacket", "net/minecraft/network/INetHandler", "net/minecraft/client/Minecraft", "getMinecraft", "currentScreen", "net/minecraft/client/gui/GuiScreen", "net/minecraft/client/gui/GuiChat"), new ObfuscatedNames("func_148833_a", "net/minecraft/network/INetHandler", "net/minecraft/client/Minecraft", "func_71410_x", "field_71462_r", "net/minecraft/client/gui/GuiScreen", "net/minecraft/client/gui/GuiChat"), new ObfuscatedNames("a", "et", "bcx", "z", "m", "bft", "bft") };
                break;
            }
            case "1.11":
            case "1.11.2": {
                OBFUSCATED_NAMES = new ObfuscatedNames[] { new ObfuscatedNames("processPacket", "net/minecraft/network/INetHandler", "net/minecraft/client/Minecraft", "getMinecraft", "currentScreen", "net/minecraft/client/gui/GuiScreen", "net/minecraft/client/gui/GuiChat"), new ObfuscatedNames("func_148833_a", "net/minecraft/network/INetHandler", "net/minecraft/client/Minecraft", "func_71410_x", "field_71462_r", "net/minecraft/client/gui/GuiScreen", "net/minecraft/client/gui/GuiChat"), new ObfuscatedNames("a", "ew", "beq", "z", "m", "bhm", "bgp") };
                break;
            }
            default: {
                throw new RuntimeException("NoCloseMyChat Lynx does not support this version of Minecraft! (Detected version 1.8.9)\nPlease contact Cecer on the Hypixel forums and I will see look into releasing an update for newer versions.");
            }
        }
    }
    
    private static class ObfuscatedNames
    {
        private final String processPacketMethodName;
        private final String iNetHandlerClassName;
        private final String minecraftClassName;
        private final String getMinecraftMethodName;
        private final String currentScreenFieldName;
        private final String guiScreenClassName;
        private final String guiChatClassName;
        
        public String getProcessPacketMethodName() {
            return this.processPacketMethodName;
        }
        
        public String getINetHandlerClassName() {
            return this.iNetHandlerClassName;
        }
        
        public String getMinecraftClassName() {
            return this.minecraftClassName;
        }
        
        public String getGetMinecraftMethodName() {
            return this.getMinecraftMethodName;
        }
        
        public String getCurrentScreenFieldName() {
            return this.currentScreenFieldName;
        }
        
        public String getGuiScreenClassName() {
            return this.guiScreenClassName;
        }
        
        public String getGuiChatClassName() {
            return this.guiChatClassName;
        }
        
        private ObfuscatedNames(final String processPacketMethodName, final String iNetHandlerClassName, final String minecraftClassName, final String getMinecraftMethodName, final String currentScreenFieldName, final String guiScreenClassName, final String guiChatClassName) {
            this.processPacketMethodName = processPacketMethodName;
            this.iNetHandlerClassName = iNetHandlerClassName;
            this.minecraftClassName = minecraftClassName;
            this.getMinecraftMethodName = getMinecraftMethodName;
            this.currentScreenFieldName = currentScreenFieldName;
            this.guiScreenClassName = guiScreenClassName;
            this.guiChatClassName = guiChatClassName;
        }
    }
}
