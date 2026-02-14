package emi.coremod;

import cpw.mods.fml.relauncher.IClassTransformer;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

public class EmiParticleFixer implements IClassTransformer {

    @Override
    public byte[] transform(String name, byte[] bytes) {
        // In Forge 1.4.7, the method transform sonly recives (String name, byte[] bytes)
        // 'azr' is the ofuscated name EffectRenderer en 1.4.7
        if (name.equals("azr") || name.equals("net.minecraft.client.particle.EffectRenderer")) {
            System.out.println("[EmiCoreMod] Aplicando parche de seguridad contra crash de particulas...");
            return patch(bytes);
        }
        return bytes;
    }

    private byte[] patch(byte[] bytes) {
        ClassNode cn = new ClassNode();
        ClassReader cr = new ClassReader(bytes);
        cr.accept(cn, 0);

        for (Object obj : cn.methods) {
            MethodNode mn = (MethodNode) obj;

            // The method 'a' is renderParticles in 1.4.7 version
             if (mn.name.equals("a") || mn.name.equals("renderParticles")) {
                LabelNode start = new LabelNode();
                LabelNode end = new LabelNode();
                LabelNode handler = new LabelNode();
                
                mn.instructions.insert(start);
                mn.instructions.add(end);
                mn.instructions.add(handler);
                
                // If have unexpected error, come back (RETURN) methoid to prevent game crash
                mn.instructions.add(new InsnNode(Opcodes.RETURN));
                
                // Registry block try-catch for catch the IndexOutOfBoundsException
                mn.tryCatchBlocks.add(new TryCatchBlockNode(start, end, handler, "java/lang/IndexOutOfBoundsException"));
            }
        }
        
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        cn.accept(cw);
        return cw.toByteArray();
    }
}
